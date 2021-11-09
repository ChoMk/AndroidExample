package com.example.androidexample.repository.user

import android.util.Log
import com.example.androidexample.network.HttpClient
import com.example.androidexample.network.service.UserService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * @author MyeongKi
 */
class UserRemoteRepository : UserRepository {
    override fun getUser(userId: String): Single<User> {
        return HttpClient.client
            .create(UserService::class.java)
            .getUser(userId)
            .subscribeOn(Schedulers.io())
            .map {
                it.user
            }
            .onErrorReturn { error ->
                Log.d("error", error.toString())
                User()
            }
    }

    override fun getUsers(): Single<List<User>> {
        return HttpClient.client
            .create(UserService::class.java)
            .getUsers()
            .subscribeOn(Schedulers.io())
            .map {
                it.users
            }
            .onErrorReturn { error ->
                Log.d("error", error.toString())
                emptyList()
            }
    }

    override fun addUser(user: User): Single<Boolean> {
        return HttpClient.client
            .create(UserService::class.java)
            .addUser(user)
            .subscribeOn(Schedulers.io())
            .map {
                it.success
            }
            .onErrorReturn { error ->
                Log.d("error", error.toString())
                false
            }
    }
    companion object {
        fun getInstance(): UserRemoteRepository {
            return LazyHolder.INSTANCE
        }
    }

    private object LazyHolder {
        val INSTANCE = UserRemoteRepository()
    }
}
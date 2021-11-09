package com.example.androidexample.repository.user

import io.reactivex.Single

/**
 * @author MyeongKi
 */
interface UserRepository {
    fun getUser(userId: String): Single<User>
    fun getUsers(): Single<List<User>>
    fun addUser(user: User): Single<Boolean>
}
package com.example.androidexample.network.service

import com.example.androidexample.network.respnse.DefaultResponse
import com.example.androidexample.network.respnse.UserResponse
import com.example.androidexample.network.respnse.UsersResponse
import com.example.androidexample.repository.user.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author MyeongKi
 */
interface UserService {
    @GET("/users")
    fun getUsers(): Single<UsersResponse>

    @GET("/users/user")
    fun getUser(@Query("user_id") userId: String): Single<UserResponse>

    @POST("/users/add")
    fun addUser(@Body user: User): Single<DefaultResponse>
}
package com.example.androidexample.network.respnse

import com.example.androidexample.repository.user.User
import com.google.gson.annotations.SerializedName

/**
 * @author MyeongKi
 */
class UsersResponse {
    @SerializedName("success")
    val success: Boolean = false

    @SerializedName("users")
    val users: List<User> = emptyList()
}
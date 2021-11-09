package com.example.androidexample.network.respnse

import com.example.androidexample.repository.user.User
import com.google.gson.annotations.SerializedName

/**
 * @author MyeongKi
 */
class UserResponse {
    @SerializedName("success")
    val success: Boolean = false

    @SerializedName("user")
    val user: User = User()
}
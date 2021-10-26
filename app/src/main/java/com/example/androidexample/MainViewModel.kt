package com.example.androidexample

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @author MyeongKi
 */
class MainViewModel : ViewModel() {
    val resultNumState = ObservableField("0")
    //FIXME 가독성을 좀 더 높이면?
    fun onClickPlus() {
        (resultNumState.get()?.toInt() ?: 0).let {
            resultNumState.set((it + 1).toString())
        }
    }

    fun onClickMinus() {
        (resultNumState.get()?.toInt() ?: 0).let {
            resultNumState.set((it - 1).toString())
        }
    }
}
package com.example.androidexample

import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @author MyeongKi
 */
class MainViewModel : ViewModel() {
    private var currentImageIndex = 0

    val imageUrl = ObservableField<String>()

    init {
        if (ConstImageUrlData.imageUrls.size != 0) {
            imageUrl.set(ConstImageUrlData.imageUrls[0])
        }
    }

    fun onClickPrev() {
        if (currentImageIndex == 0) {
            Toast.makeText(SampleApp.applicationContext(), "뒤로가기 불가능", Toast.LENGTH_SHORT).show()
            return
        }
        currentImageIndex--
        imageUrl.set(ConstImageUrlData.imageUrls[currentImageIndex])
    }

    fun onClickNext() {
        if (currentImageIndex == ConstImageUrlData.imageUrls.size - 1) {
            Toast.makeText(SampleApp.applicationContext(), "앞으로가기 불가능", Toast.LENGTH_SHORT).show()
            return
        }
        currentImageIndex++
        imageUrl.set(ConstImageUrlData.imageUrls[currentImageIndex])
    }

}

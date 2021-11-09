package com.example.androidexample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidexample.R
import com.example.androidexample.databinding.ActivityUserApiTestBinding
import com.example.androidexample.util.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class UserApiTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserApiTestBinding
    private lateinit var viewModel: UserViewModel
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_api_test)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.viewmodel = viewModel
        observeEvent()
    }

    private fun observeEvent() {
        viewModel.itemEventRelay
            .ofType(UserViewModel.UsersEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                viewModel.usersResult.set(it.result.toString())
            }
            .addTo(disposable)
        viewModel.itemEventRelay
            .ofType(UserViewModel.UserEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                viewModel.userResult.set(it.result.toString())
            }
            .addTo(disposable)
        viewModel.itemEventRelay
            .ofType(UserViewModel.AddSuccessEvent::class.java)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Toast.makeText(this, it.isSuccess.toString(), Toast.LENGTH_SHORT).show()
            }
            .addTo(disposable)
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
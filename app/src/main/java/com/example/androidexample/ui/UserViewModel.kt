package com.example.androidexample.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.androidexample.repository.user.User
import com.example.androidexample.repository.user.UserRemoteRepository
import com.example.androidexample.util.RxAction
import com.example.androidexample.util.addTo
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import io.reactivex.disposables.CompositeDisposable

/**
 * @author MyeongKi
 */
class UserViewModel : ViewModel() {
    private val userRepository = UserRemoteRepository.getInstance()
    private val disposables = CompositeDisposable()

    val usersResult = ObservableField("로딩 이전 상태...")
    val userResult = ObservableField("검색 결과")
    val name = ObservableField("")
    val id = ObservableField("")
    val searchId = ObservableField("")

    val itemEventRelay: Relay<RxAction> = PublishRelay.create()

    fun loadUsers() {
        userRepository.getUsers()
            .subscribe { result ->
                itemEventRelay.accept(UsersEvent(result))
            }
            .addTo(disposables)
    }

    fun addUser() {
        userRepository.addUser(User(name = name.get() ?: "", id = id.get() ?: ""))
            .subscribe { result ->
                itemEventRelay.accept(AddSuccessEvent(result))
            }
            .addTo(disposables)
    }

    fun searchUser() {
        userRepository.getUser(searchId.get() ?: "")
            .subscribe { result ->
                itemEventRelay.accept(UserEvent(result))
            }
            .addTo(disposables)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    class UsersEvent(val result: List<User>) : RxAction
    class UserEvent(val result: User) : RxAction
    class AddSuccessEvent(val isSuccess: Boolean) : RxAction
}

package com.mobiledevpro.app.ui.userviewscreen.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.mobiledevpro.common.ui.base.BaseViewModel
import com.mobiledevpro.domain.model.User
import com.mobiledevpro.domain.userdata.UserDataInteractor
import com.mobiledevpro.domain.userdata.UserDataInteractorImpl
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy


/**
 * ViewModel for user data
 *
 *
 * Created by Dmitriy Chernysh
 *
 * http://androiddev.pro
 *
 * #MobileDevPro
 */
class UserDataViewModel @ViewModelInject constructor(
    private val interactor: UserDataInteractorImpl
) : BaseViewModel() {

    val cachedUserData = MutableLiveData<User>()

    init {
        observeUserData()
    }

    private fun observeUserData() {
        interactor.observeUserData()
            .subscribeBy { user ->
                cachedUserData.value = user
            }
            .addTo(subscriptions)
    }


}

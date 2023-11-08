package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp3_parcial_belgrano_grupo4.domain.GetOwnerAttributeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getOwnerAttributeUseCase : GetOwnerAttributeUseCase,
): ViewModel() {

    //userimage
    private val _userImageUrl = MutableLiveData<String>()
    val userImageUrl: LiveData<String> =  _userImageUrl

    //username
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    //userPhone
    private val _userPhone = MutableLiveData<String>()
    val userPhone : LiveData<String> = _userPhone

    suspend fun getImageUrl(id: Int){
        val imageUrl = getOwnerAttributeUseCase.invoke(0, "image")
        setImageUrl(imageUrl)
    }


    fun setImageUrl(imageUrl: String) {
        _userImageUrl.value = imageUrl
    }

    fun setUserPhone(phone: String) {
        _userPhone.value = phone
    }

    fun setUserName(name: String) {
        _userName.value = name
    }
}
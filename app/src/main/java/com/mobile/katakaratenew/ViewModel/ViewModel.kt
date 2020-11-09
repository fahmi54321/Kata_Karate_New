package com.mobile.katakaratenew.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.katakaratenew.Model.ResponsePenilaian
import com.mobile.katakaratenew.Repository.Repository

class ViewModel:ViewModel() {

    // todo 2 inisiaslisasi repository
    val repository = Repository()

    // todo 3 membuat variabel agar bisa ditampung oleh view
    var responPenilaian = MutableLiveData<ResponsePenilaian>()
    var errorPenilaian = MutableLiveData<Throwable>()
    var showLoading = MutableLiveData<Boolean>()

    // todo 4 membuat fungsi yang diperlukan
    fun penilaia(
        nomor:String,
        teknik:String,
        atletik:String
    ){
        showLoading.value = true
        repository.penilaia(nomor,teknik,atletik,{
            responPenilaian.value = it
            showLoading.value = false
        },{
            errorPenilaian.value = it
            showLoading.value = false
        })
    }
}
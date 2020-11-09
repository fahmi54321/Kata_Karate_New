package com.mobile.katakaratenew.Repository

import com.mobile.katakaratenew.Model.ResponsePenilaian
import com.mobile.katakaratenew.network.kotlin.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun penilaia(
        nomor: String,
        teknik: String,
        atletik: String,
        responseHandler: (ResponsePenilaian) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().penilaian(nomor, teknik, atletik)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }
}
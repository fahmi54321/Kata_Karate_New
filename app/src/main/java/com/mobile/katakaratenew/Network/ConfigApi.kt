package com.mobile.katakaratenew.network.kotlin

import com.mobile.katakaratenew.Model.ResponsePenilaian
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*


//todo 2.1 Config API
interface ConfigApi {

    @FormUrlEncoded
    @POST("penilaian.php")
    fun penilaian(
        @Field("nomor") nomor:String,
        @Field("teknik") teknik:String,
        @Field("atletik") atletik:String
    ): Single<ResponsePenilaian>
    //todo Single jika response nya cuma satu yaitu berhasil atau gagal
    //todo Observable jika response nya banyak
    //todo Flowable jika response nya banyak

}
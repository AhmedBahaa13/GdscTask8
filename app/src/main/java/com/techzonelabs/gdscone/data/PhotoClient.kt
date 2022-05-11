package com.techzonelabs.gdscone.data

import com.techzonelabs.gdscone.data.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class PhotoClient() {

        val retrofitInstance: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    var apiInterface = retrofitInstance.create(ApiInterface::class.java)

    companion object {
        private var photoClient: PhotoClient? = null
        fun getInstance(): PhotoClient {
            if (photoClient == null) {
                photoClient = PhotoClient()
                return photoClient as PhotoClient
            } else return photoClient as PhotoClient
        }
    }

}
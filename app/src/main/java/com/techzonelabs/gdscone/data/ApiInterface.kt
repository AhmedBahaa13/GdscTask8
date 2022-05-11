package com.techzonelabs.gdscone.data

import com.techzonelabs.gdscone.data.models.PhotoModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
  @GET("photos")
  fun getPhotos():Call<List<PhotoModel>>
}
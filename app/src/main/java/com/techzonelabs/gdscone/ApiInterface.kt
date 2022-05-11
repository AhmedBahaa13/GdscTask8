package com.techzonelabs.gdscone

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
  @GET("photos")
  fun getPhotos():Call<List<PhotoModel>>
}
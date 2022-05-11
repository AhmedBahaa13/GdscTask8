package com.techzonelabs.gdscone.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techzonelabs.gdscone.data.PhotoClient
import com.techzonelabs.gdscone.data.models.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosViewModel:ViewModel() {
  private val photosMutableLiveData = MutableLiveData<List<PhotoModel>>()
   val photosLiveData:LiveData<List<PhotoModel>> get() = photosMutableLiveData
    init {
        getPhotos()
    }

    private fun getPhotos(){
        PhotoClient.getInstance().apiInterface.getPhotos().enqueue(object :
            Callback<List<PhotoModel>> {
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
                photosMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
            }

        })
    }
}
package com.techzonelabs.gdscone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.techzonelabs.gdscone.ui.adapter.PhotosAdapter
import com.techzonelabs.gdscone.ui.viewModels.PhotosViewModel
import com.techzonelabs.gdscone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter by lazy { PhotosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[PhotosViewModel::class.java]

        viewModel.photosLiveData.observe(this){
            adapter.setList(it)
        }
        binding.recyclerView.adapter = adapter
    }
}
package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.databinding.ActivityUploadBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    fun signIn(view:View){

    }
    fun signUp(view: View){

    }
}
package com.example.instagramclone


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.instagramclone.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarLogin.title="Giriş"
        setSupportActionBar(binding.toolbarLogin)

        auth=Firebase.auth
        val currentUser=auth.currentUser
        if(currentUser!=null){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun signIn(view:View){
        val email=binding.editTextEmail.text.toString()
        val password=binding.editTextPassword.text.toString()
        if(!email.equals("") || !password.equals("")) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }

    }
    fun signUp(view: View){
        val email=binding.editTextEmail.text.toString()
        val password=binding.editTextPassword.text.toString()
        if(!email.equals("") || !password.equals("")) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }



    }
}
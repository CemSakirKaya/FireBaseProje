package com.example.firebaseproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.firebaseproje.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            auth= FirebaseAuth.getInstance()
        binding.buttonSave.setOnClickListener{
            val name = binding.etName.text.toString().trim()
            val age = binding.etNameAge.text.toString().trim()
            val explanation = binding.etExplanation.text.toString().trim()
            if(TextUtils.isEmpty(name)){
                binding.etName.error = "Please dont leave empty this area"
            }
            if(TextUtils.isEmpty(age)){
                binding.etNameAge.error = "Please dont leave empty this area"
            }
            if(TextUtils.isEmpty(explanation)){
                binding.etExplanation.error = "Please dont leave empty this area"
            }
            else{
                firebaseDatabase = FirebaseDatabase.getInstance()
                var databasereference = firebaseDatabase.reference.child("Users")
                var id = databasereference.push()

                id.child("id").setValue(id.key.toString())
                id.child("name").setValue(name)
                id.child("age").setValue(age)
                id.child("explanation").setValue(explanation)
                Toast.makeText(this,"User saved to system ",Toast.LENGTH_LONG).show()

            }





        }




    }



}
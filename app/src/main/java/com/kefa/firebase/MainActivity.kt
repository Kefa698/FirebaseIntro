package com.kefa.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var database: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = FirebaseDatabase.getInstance()

        btnsave.setOnClickListener {
            var firstName: String = edtfirst.text.toString()
            var secondName: String = edtsecond.text.toString()
            var email: String = edtemail.text.toString()
            var phoneNumber: String = edtphone.toString()

            saveUserDetails(
                Userdetails(firstName, secondName, email, phoneNumber)
            )
        }
    }

    fun saveUserDetails(userDetails: Userdetails) {
        var databaseReference: DatabaseReference = database.getReference("userdetails")

        databaseReference.child("users").setValue(userDetails)

    }
}

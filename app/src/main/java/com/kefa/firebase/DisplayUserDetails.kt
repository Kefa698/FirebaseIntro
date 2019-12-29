package com.kefa.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*

class DisplayUserDetails : AppCompatActivity() {
    var database = FirebaseDatabase.getInstance()
    var databaseReference: DatabaseReference = database.getReference("userdetails")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user_details)
//        get data from firebase

        val dataListener = object : ValueEventListener {
            override fun onCancelled(data: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                val userdetails = data.getValue(Userdetails::class.java)

                Log.e("User Details", "$data")
            }

        }
        databaseReference.addValueEventListener(dataListener)
    }
}

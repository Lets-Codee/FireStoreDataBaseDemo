package com.letscodee.firestoredemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uuidBtn = findViewById<Button>(R.id.uuidBtn)
        val sqBtn = findViewById<Button>(R.id.seqBtn)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val number = findViewById<EditText>(R.id.number)
        val message = findViewById<EditText>(R.id.message)
        val learn = findViewById<EditText>(R.id.learn)
        val id = findViewById<EditText>(R.id.firestoreid)

        val city: MutableMap<String, String> = HashMap()


        val db = FirebaseFirestore.getInstance()

        uuidBtn.setOnClickListener {

            city["Name"] = name.text.toString().trim()
            city["Email"] = email.text.toString().trim()
            city["Number"] = number.text.toString().trim()
            city["Message"] = message.text.toString().trim()
            city["Learn"] = learn.text.toString().trim()
            val id = UUID.randomUUID().toString()
            db.collection("Unique Id").document(id)
                .set(city)
                .addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "DocumentSnapshot successfully written!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "DocumentSnapshot not successfully written!",
                        Toast.LENGTH_LONG
                    ).show()
                    Log.w("Tag", "Error writing document", it);
                }

        }

        sqBtn.setOnClickListener {

            city["Name"] = name.text.toString().trim()
            city["Email"] = email.text.toString().trim()
            city["Number"] = number.text.toString().trim()
            city["Message"] = message.text.toString().trim()
            city["Learn"] = learn.text.toString().trim()
            val db = FirebaseFirestore.getInstance()
            db.collection("Custom Id").document(id.text.toString().trim())
                .set(city)
                .addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "DocumentSnapshot successfully written!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "DocumentSnapshot not successfully written!",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }
}
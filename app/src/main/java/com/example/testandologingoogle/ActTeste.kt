package com.example.testandologingoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_act_teste.*

class ActTeste : AppCompatActivity() {

    lateinit var  google_auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_teste)

        google_auth = FirebaseAuth.getInstance()
        val currentUser = google_auth.currentUser

        textView.text = currentUser?.displayName
        textView2.text = currentUser?.email

        Picasso.get().load(currentUser?.photoUrl).into(imageView2)

        botao_de_logoff.setOnClickListener {
            logOff()
        }
    }

    fun logOff() {
        google_auth.signOut()
        Toast.makeText(this,"Saindo!", Toast.LENGTH_LONG).show()
        finish()
    }
}
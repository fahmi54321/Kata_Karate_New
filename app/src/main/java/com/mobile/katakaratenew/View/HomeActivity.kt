package com.mobile.katakaratenew.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.katakaratenew.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        wasit1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("wasit","1")
            startActivity(intent)
        }

        wasit2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("wasit","2")
            startActivity(intent)
        }

        wasit3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("wasit","3")
            startActivity(intent)
        }

        wasit4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("wasit","4")
            startActivity(intent)
        }

        wasit5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("wasit","5")
            startActivity(intent)
        }
    }
}
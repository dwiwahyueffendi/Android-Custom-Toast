package com.example.androidcustomtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGeneralToast.setOnClickListener(){
            showToast()
        }
    }

    private fun showToast(){
        val toastView = layoutInflater.inflate(
                R.layout.layout_toast,
                findViewById(R.id.layoutToastContainer)
        )

        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }
}
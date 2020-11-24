package com.example.androidcustomtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showToast(toastType: Int){
        val toastView = layoutInflater.inflate(
                R.layout.layout_toast,
                findViewById(R.id.layoutToastContainer)
        )

        val toastContainer = toastView.findViewById<LinearLayout>(R.id.layoutToastContainer)
        val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
        val textMessage = toastView.findViewById<TextView>(R.id.textMessage)

        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }
}
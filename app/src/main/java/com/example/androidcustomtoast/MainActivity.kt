package com.example.androidcustomtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
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

        buttonSuccessToast.setOnClickListener{
            showToast(Constants.TOAST_TYPE_SUCCESS, "Success Toast")
        }

        buttonWarningToast.setOnClickListener {
            showToast(Constants.TOATS_TYPE_WARNING, "Warning Toast")
        }

        buttonErrorToast.setOnClickListener {
            showToast(Constants.TOAST_TYPE_ERROR, "Error Toast")
        }
    }

    private fun showToast(toastType: Int, message: CharSequence){
        val toastView = layoutInflater.inflate(
                R.layout.layout_toast,
                findViewById(R.id.layoutToastContainer)
        )

        val toastContainer = toastView.findViewById<LinearLayout>(R.id.layoutToastContainer)
        val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
        val textMessage = toastView.findViewById<TextView>(R.id.textMessage)

        when(toastType){
            Constants.TOAST_TYPE_SUCCESS -> {
                toastContainer.setBackgroundResource(R.drawable.toast_succes_background)
                imageIcon.setImageResource(R.drawable.ic_success)
                textMessage.text = message
            }

            Constants.TOATS_TYPE_WARNING -> {
                toastContainer.setBackgroundResource(R.drawable.toast_warning_background)
                imageIcon.setImageResource(R.drawable.ic_warning)
                textMessage.text = message
            }

            Constants.TOAST_TYPE_ERROR -> {
                toastContainer.setBackgroundResource(R.drawable.toast_error_background)
                imageIcon.setImageResource(R.drawable.ic_error)
                textMessage.text = message
            }
        }

        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }
}
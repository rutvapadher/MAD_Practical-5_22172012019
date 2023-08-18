package com.example.mad_practical_5_22172012019

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseButton:Button = findViewById(R.id.button)
        val editTextBrowser:EditText = findViewById(R.id.editTextText4)
        browseButton.setOnClickListener {
            openURL(editTextBrowser.text.toString())
        }

    }

    fun openURL(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }

    fun phoneNo(Num: String) {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$Num")).also { startActivity(it) }
    }

    fun openCalllog(Call: String) {
         Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }

    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun setAlarm(){
       Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }

}
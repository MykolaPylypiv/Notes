package com.example.notesv2.core

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import javax.inject.Inject

interface DoToast {

    fun doToast(context: Context?, text: String, length: Int)

    class Base @Inject constructor() : DoToast {

        override fun doToast(context: Context?, text: String, length: Int) {
            Looper.prepare()
            Handler().post {
                Toast.makeText(context, text, length).show()
            }
            Looper.loop()
        }
    }
}

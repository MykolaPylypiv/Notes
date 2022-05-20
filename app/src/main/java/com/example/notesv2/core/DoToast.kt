package com.example.notesv2.core

import android.content.Context
import android.widget.Toast

interface DoToast {

    fun doToast(context: Context?, text: Int, length: Int)

    class Base : DoToast {
        override fun doToast(context: Context?, text: Int, length: Int) =
            Toast.makeText(context, text, length).show()
    }
}

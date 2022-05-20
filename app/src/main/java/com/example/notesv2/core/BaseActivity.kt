package com.example.notesv2.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.notesv2.R

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    private var _binding: B? = null
    protected val binding: B get() = checkNotNull(_binding)

    protected abstract fun initBinding(inflater: LayoutInflater?): B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initBinding(layoutInflater)
        setContentView(binding.root)

        init()
    }

    abstract fun init()
}
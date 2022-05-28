package com.example.notesv2.core

interface Mapper<From, To> {

    fun map(data: From): To

    interface Unit<T> : Mapper<T, kotlin.Unit>
}
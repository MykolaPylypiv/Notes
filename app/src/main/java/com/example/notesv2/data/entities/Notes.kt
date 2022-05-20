package com.example.notesv2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "theme") var theme: String? = "",
    @ColumnInfo(name = "content") var content: String? = "",
    @ColumnInfo(name = "isLike") var isLike: Boolean = false,
)
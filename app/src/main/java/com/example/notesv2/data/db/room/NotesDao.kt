package com.example.notesv2.data.db.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesv2.data.entities.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: Notes)

    @Delete
    suspend fun delete(notes: Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE isLike=:isLike")
    fun getLikeNotes(isLike: Boolean = true): LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE uid=:uid")
    fun findByUid(uid: Int): LiveData<Notes>

    @Query("DELETE FROM notes")
    suspend fun deleteAll()
}

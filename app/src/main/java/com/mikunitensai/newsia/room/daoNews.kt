package com.mikunitensai.newsia.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.mikunitensai.newsia.model.News

@Dao
interface daoNews {
    @Insert(onConflict = REPLACE)
    fun insert(data: News)

    @Delete
    fun delete(data: News)

    @Update
    fun update(data: News): Int

    @Query("SELECT * from favorit ORDER BY id ASC")
    fun getAll(): List<News>

    @Query("SELECT * FROM favorit WHERE id = :id LIMIT 1")
    fun getNote(id: Int): News

    @Query("DELETE FROM favorit")
    fun deleteAll(): Int
}
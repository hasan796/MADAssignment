package com.cs191014.assignment1.ui.home
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecordDao {
    @Query("SELECT * FROM record")
    fun getAll(): List<Record>

    @Query("SELECT * FROM record WHERE id IN (:recordIds)")
    fun loadAllByIds(recordIds: IntArray): List<Record>

    @Query("SELECT * FROM record WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Record

    @Insert
    fun insertAll(vararg record: Record)

    @Delete
    fun delete(record: Record)
}
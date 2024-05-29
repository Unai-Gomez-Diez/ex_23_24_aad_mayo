package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.Animal

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animal")
    fun getAnimals():List<AnimalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAnimals(animals: List<AnimalEntity>)

    @Query("DELETE FROM animal")
    fun deleteAnimals()
}
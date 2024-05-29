package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalTypeDao {

    @Query("SELECT * FROM animal_type")
    fun getAnimalTypes(): List<AnimalTypeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAnimalTypes(animalTypeEntity: AnimalTypeEntity)
}
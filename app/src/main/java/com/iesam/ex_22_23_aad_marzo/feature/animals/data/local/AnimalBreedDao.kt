package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalBreedDao {

    @Query("SELECT * FROM animal_breed")
    fun getAnimalBreeds():List<AnimalBreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAnimalBreeds(animalBreeds: AnimalBreedEntity)
}
package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_breed")
data class AnimalBreedEntity (
    @PrimaryKey val id:Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name = "country") val country: String
)
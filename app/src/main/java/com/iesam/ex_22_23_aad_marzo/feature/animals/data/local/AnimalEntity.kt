package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal")
data class AnimalEntity(
    @PrimaryKey val id:Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name = "type_id") val typeIdEntity: Int,
    @ColumnInfo(name = "type_type") val typeTypeEntity: String,
    @ColumnInfo(name = "animal_id_breed") val animalIdBreedEntity: Int,
    @ColumnInfo(name = "animal_name_breed") val animalNameBreed: String,
    @ColumnInfo(name = "animal_country_breed") val animalCountryBreed: String
)

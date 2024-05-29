package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.Animal
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalBreed
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalType

fun AnimalBreed.toEntity(): AnimalBreedEntity = AnimalBreedEntity(
    this.id,
    this.name,
    this.country
)
fun AnimalBreedEntity.toDomain(): AnimalBreed = AnimalBreed(
    this.id,
    this.name,
    this.country
)

fun AnimalType.toEntity(): AnimalTypeEntity = AnimalTypeEntity(
    this.id,
    this.type
)
fun AnimalTypeEntity.toDomain(): AnimalType = AnimalType(
    this.id,
    this.name
)

fun Animal.toEntity(): AnimalEntity = AnimalEntity(
    this.id,
    this.name,
    this.type.id,
    this.type.type,
    this.animalBreed.id,
    this.animalBreed.name,
    this.animalBreed.country
)

fun AnimalEntity.toDomain(): Animal = Animal(
    this.id,
    this.name,
    AnimalType(this.typeIdEntity, this.typeTypeEntity),
    AnimalBreed(this.animalIdBreedEntity, this.animalNameBreed, this.animalCountryBreed)
)
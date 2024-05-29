package com.iesam.ex_22_23_aad_marzo.feature.animals.data.remote

import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.Animal
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalBreed
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalType

class AnimalRemoteDataSource {

    private val mockAnimals = listOf(
        Animal(1, "Tux", AnimalType(1, "Gato"), AnimalBreed(2, "Caniche", "Méjico")),
        Animal(2, "Dino", AnimalType(2, "Perro"), AnimalBreed(2, "Caniche", "Méjico")),
        Animal(3, "Bambam", AnimalType(2, "Perro"), AnimalBreed(3, "Dogo", "Alemania")),
        Animal(4, "Tango", AnimalType(2, "Perro"), AnimalBreed(4, "Podenco", "Francés")),
        Animal(5, "Git", AnimalType(1, "Gato"), AnimalBreed(1, "Mixto", "Europeo"))
    )

    fun getAnimals(): List<Animal> = mockAnimals

    fun getAnimal(animalId: Int) = mockAnimals.firstOrNull { it.id == animalId }

}
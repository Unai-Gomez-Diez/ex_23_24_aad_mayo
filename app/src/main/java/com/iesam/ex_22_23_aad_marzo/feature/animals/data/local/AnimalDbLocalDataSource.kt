package com.iesam.ex_22_23_aad_marzo.feature.animals.data.local

import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.Animal
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalBreed
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalType

class AnimalDbLocalDataSource(
    private val animalDao: AnimalDao,
    private val animalBreedDao: AnimalBreedDao,
    private val animalTypeDao: AnimalTypeDao
) {
    fun getAnimal():List<Animal>{
        return animalDao.getAnimals().map {
            it.toDomain()
        }
    }
    fun setAnimal(animals: List<Animal>){
        animalDao.setAnimals(animals.map {
            it.toEntity()
        })
    }

    fun deleteAnimals(){
        animalDao.deleteAnimals()
    }

    fun getAnimalType():List<AnimalType>{
        return animalTypeDao.getAnimalTypes().map {
            it.toDomain()
        }
    }
    fun setAnimalType(animalTypes: AnimalType){
        animalTypeDao.setAnimalTypes(animalTypes.toEntity())
    }

    fun getAnimalBreed():List<AnimalBreed>{
        return animalBreedDao.getAnimalBreeds().map {
            it.toDomain()
        }
    }
    fun setAnimalBreed(animalBreeds: AnimalBreed){
        animalBreedDao.setAnimalBreeds(animalBreeds.toEntity())

    }

}
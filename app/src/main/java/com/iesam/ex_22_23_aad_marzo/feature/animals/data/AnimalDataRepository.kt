package com.iesam.ex_22_23_aad_marzo.feature.animals.data

import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalDbLocalDataSource
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.remote.AnimalRemoteDataSource
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.Animal
import com.iesam.ex_22_23_aad_marzo.feature.animals.domain.AnimalBreed

class AnimalDataRepository(
    private val animalDbLocalDataSource: AnimalDbLocalDataSource,
    private val animalRemoteDataSource: AnimalRemoteDataSource
) {
    fun getAnimals(): List<Animal>{
        var data = animalDbLocalDataSource.getAnimal()
        return if (data.isNullOrEmpty()){
            data = animalRemoteDataSource.getAnimals()
            data.map {
                animalDbLocalDataSource.setAnimalBreed(it.animalBreed)
                animalDbLocalDataSource.setAnimalType(it.type)
            }
            animalDbLocalDataSource.setAnimal(data)
            data
        }else{
            data
        }
    }

    fun getAnimalBreeds():List<AnimalBreed>{
        return animalDbLocalDataSource.getAnimalBreed()
    }
    fun deleteAnimals(){
        animalDbLocalDataSource.deleteAnimals()
    }
}
package com.iesam.ex_22_23_aad_marzo.feature

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.iesam.ex_22_23_aad_marzo.R

import com.iesam.ex_22_23_aad_marzo.feature.tapas.data.TapasDataRepository
import com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote.TapasDbDataSource
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Establishment
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.PhotoTapas
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Tapa
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import com.iesam.ex_22_23_aad_marzo.feature.animals.data.AnimalDataRepository
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.AppDataBase
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalDbLocalDataSource
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.remote.AnimalRemoteDataSource

import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button?>(R.id.action_delete_user).setOnClickListener {
            deleteLogin()
        }
        findViewById<Button?>(R.id.action_delete_animals).setOnClickListener {
            deleteAnimals()
        }



        deleteAnimals()

        initLogin()
        initAnimals()
        initAnimalBreed()
        initTapas()
    }

    private fun initLogin() {
        val email = "example@email.es"
        val password = "example_password"

        //Llamar al repositorio
        //LoginRepository loginRepository = ...
    }

    private fun deleteLogin() {
        //Eliminar datos del login.
    }

    private fun initAnimals() {
        thread {
           val animalDataRepository = AnimalDataRepository(
               AnimalDbLocalDataSource(AppDataBase.getInstance(this).animalDao(),
                   AppDataBase.getInstance(this).animalBreedDao(),
                   AppDataBase.getInstance(this).animalTypeDao()),
               AnimalRemoteDataSource()
           )
            Log.d("@dev",animalDataRepository.getAnimals().toString())
        }
    }

    private fun initAnimalBreed() {
        thread {
            val animalDataRepository = AnimalDataRepository(
                AnimalDbLocalDataSource(AppDataBase.getInstance(this).animalDao(),
                    AppDataBase.getInstance(this).animalBreedDao(),
                    AppDataBase.getInstance(this).animalTypeDao()),
                AnimalRemoteDataSource()
            )
            animalDataRepository.getAnimalBreeds()
        }
    }

    private fun deleteAnimals() {
        thread {
            val animalDataRepository = AnimalDataRepository(
                AnimalDbLocalDataSource(AppDataBase.getInstance(this).animalDao(),
                    AppDataBase.getInstance(this).animalBreedDao(),
                    AppDataBase.getInstance(this).animalTypeDao()),
                AnimalRemoteDataSource()
            )
            animalDataRepository.deleteAnimals()
        }
    }

    private fun initTapas() {
        thread {
            lifecycle.coroutineScope.launch {
                val tapasDataRepository = TapasDataRepository(TapasDbDataSource(FirebaseDatabase.getInstance()))


                Log.d("@dev",tapasDataRepository.getTapas().toString())
            }
        }
    }
}
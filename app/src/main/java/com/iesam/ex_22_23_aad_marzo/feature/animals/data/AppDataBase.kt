package com.iesam.ex_22_23_aad_marzo.feature.animals.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalBreedDao
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalBreedEntity
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalDao
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalEntity
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalTypeDao
import com.iesam.ex_22_23_aad_marzo.feature.animals.data.local.AnimalTypeEntity

@Database(
    entities = [AnimalTypeEntity::class, AnimalBreedEntity::class, AnimalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {
    //abstractfun de los dao
    abstract fun animalDao(): AnimalDao
    abstract fun animalTypeDao(): AnimalTypeDao
    abstract fun animalBreedDao(): AnimalBreedDao

    companion object{
        private var INSTANCE : AppDataBase? = null
        fun getInstance(context: Context):AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
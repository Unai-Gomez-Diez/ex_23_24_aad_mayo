package com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote

import com.google.firebase.database.FirebaseDatabase
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Tapa
import kotlinx.coroutines.tasks.await

class TapasDbDataSource(private val firebase: FirebaseDatabase) {

    suspend fun getTapas():List<Tapa>{
        return firebase.getReference("tapa").get().await().children.map {
            it.getValue(TapaDbRemoteModel::class.java)!!.toDomain()
        }
    }
}
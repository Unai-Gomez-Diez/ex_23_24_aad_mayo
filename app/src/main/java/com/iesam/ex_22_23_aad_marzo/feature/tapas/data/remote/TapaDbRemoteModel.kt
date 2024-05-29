package com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote

import android.content.ClipDescription
import com.google.firebase.database.PropertyName
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Establishment
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.PhotoTapas

data class TapaDbRemoteModel(
    @get:PropertyName("id") @set:PropertyName("id") var id: Int = 0,
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("description") @set:PropertyName("description") var description: String = "",
    @get:PropertyName("establishment") @set:PropertyName("establishment") var establishment: EstablishmentDbRemoteModel? = null,
    @get:PropertyName("photoTapas") @set:PropertyName("photoTapas") var photoTapas: List<PhotoTapasDbRemoteModel>? = null
)
package com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote

import com.google.firebase.database.PropertyName

data class EstablishmentDbRemoteModel(
    @get:PropertyName("id") @set:PropertyName("id") var id: Int = 0,
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
)
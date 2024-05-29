package com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote

import com.google.firebase.database.PropertyName

data class PhotoTapasDbRemoteModel(
    @get:PropertyName("id") @set:PropertyName("id") var id: Int = 0,
    @get:PropertyName("url") @set:PropertyName("url") var url: String = "",
)
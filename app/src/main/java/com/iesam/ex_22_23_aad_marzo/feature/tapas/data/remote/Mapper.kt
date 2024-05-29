package com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote

import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Establishment
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.PhotoTapas
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Tapa
import kotlin.concurrent.thread

fun TapaDbRemoteModel.toDomain(): Tapa = Tapa(
    this.id,
    this.name,
    this.description,
    this.establishment!!.toDomain(),
    this.photoTapas!!.map {
        it.toDomain()
    }
)
fun EstablishmentDbRemoteModel.toDomain(): Establishment = Establishment(
    this.id,
    this.name
)

fun PhotoTapasDbRemoteModel.toDomain(): PhotoTapas = PhotoTapas(
    this.id,
    this.url
)
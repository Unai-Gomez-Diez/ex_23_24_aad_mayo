package com.iesam.ex_22_23_aad_marzo.feature.tapas.data

import com.iesam.ex_22_23_aad_marzo.feature.tapas.data.remote.TapasDbDataSource
import com.iesam.ex_22_23_aad_marzo.feature.tapas.domain.Tapa

class TapasDataRepository(private val tapasDbDataSource: TapasDbDataSource) {
    suspend fun getTapas():List<Tapa>{
        return tapasDbDataSource.getTapas()
    }


}
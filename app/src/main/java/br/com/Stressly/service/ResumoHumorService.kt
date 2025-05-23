package br.com.Stressly.service

import br.com.Stressly.domain.model.ResumoHumor
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ResumoHumorService {
    @GET("resumo-humor")
    suspend fun getResumoHumor(): ResumoHumor

    @POST("resumo-humor")
    suspend fun createResumoHumor(@Body resumoHumor: ResumoHumor): ResumoHumor

}
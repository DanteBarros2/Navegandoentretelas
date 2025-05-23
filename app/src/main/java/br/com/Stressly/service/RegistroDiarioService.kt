package br.com.Stressly.service

import br.com.Stressly.domain.model.RegistroDiario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface RegistroDiarioService {
    @GET("registros")
    suspend fun getRegistros(): List<RegistroDiario>

    @POST("registros")
    suspend fun createRegistro(@Body registro: RegistroDiario): RegistroDiario

    @DELETE("registros/{id}")
    suspend fun deleteRegistro(@Path("id") id: String)

}

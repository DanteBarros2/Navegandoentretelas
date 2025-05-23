package br.com.Stressly.service

import ChatBotApiService
import InformacoesApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {
    private val URL = "https://stressly.com.br/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getResumoHumor(): ResumoHumorService {
        return retrofitFactory.create(ResumoHumorService::class.java)
    }

    fun createResumohumor(): ResumoHumorService {
        return retrofitFactory.create(ResumoHumorService::class.java)
    }

    fun getRegistros(): RegistroDiarioService {
        return retrofitFactory.create(RegistroDiarioService::class.java)
    }

    fun createRegistro(): RegistroDiarioService {
        return retrofitFactory.create(RegistroDiarioService::class.java)
    }

    fun deleteRegistro(): RegistroDiarioService {
        return retrofitFactory.create(RegistroDiarioService::class.java)
    }

    fun getInformacoes(): InformacoesApiService {
        return retrofitFactory.create(InformacoesApiService::class.java)
    }

    fun updateInformacoes(): InformacoesApiService {
        return retrofitFactory.create(InformacoesApiService::class.java)
    }

    fun sendMessage(): ChatBotApiService {
        return retrofitFactory.create(ChatBotApiService::class.java)
    }
}
package br.com.Stressly.domain.repository

import InformacoesApiService
import br.com.Stressly.presentation.informacoes.InformacoesUiState

class InformacoesRepository(private val apiService: InformacoesApiService) {

    suspend fun getInformacoes(): InformacoesUiState {
        return apiService.getInformacoes()
    }

    suspend fun updateInformacoes(novoEstado: InformacoesUiState): InformacoesUiState {
        return apiService.updateInformacoes(novoEstado)
    }
}

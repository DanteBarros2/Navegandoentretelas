package br.com.Stressly.presentation.registrodiario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.Stressly.domain.model.CargaTrabalho
import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.usecase.SalvarRegistroDiarioUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class RegistroDiarioViewModel(
    private val salvarRegistroDiarioUseCase: SalvarRegistroDiarioUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RegistroDiarioUiState())
    val uiState: StateFlow<RegistroDiarioUiState> = _uiState

    fun selecionarEmoji(emoji: Emoji) {
        _uiState.value = _uiState.value.copy(emojiSelecionado = emoji)
    }

    fun selecionarEstadoEmocional(estado: EstadoEmocional) {
        _uiState.value = _uiState.value.copy(estadoEmocionalSelecionado = estado)
    }

    fun selecionarCargaTrabalho(carga: CargaTrabalho) {
        _uiState.value = _uiState.value.copy(cargaTrabalhoSelecionada = carga)
    }

    fun salvarRegistro() {
        val estado = _uiState.value

        if (estado.emojiSelecionado == null || estado.estadoEmocionalSelecionado == null || estado.cargaTrabalhoSelecionada == null) {
            _uiState.value = estado.copy(erro = "Preencha todos os campos.")
            return
        }

        val registro = RegistroDiario(
            data = LocalDate.now(),
            emoji = estado.emojiSelecionado,
            estadoEmocional = estado.estadoEmocionalSelecionado,
            cargaTrabalho = estado.cargaTrabalhoSelecionada
        )

        viewModelScope.launch {
            try {
                salvarRegistroDiarioUseCase(registro)
                _uiState.value = estado.copy(registroSalvoComSucesso = true)
            } catch (e: Exception) {
                _uiState.value = estado.copy(erro = "Erro ao salvar registro.")
            }
        }
    }
}

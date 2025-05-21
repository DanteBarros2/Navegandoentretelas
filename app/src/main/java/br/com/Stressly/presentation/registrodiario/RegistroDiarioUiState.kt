package br.com.Stressly.presentation.registrodiario

import br.com.Stressly.domain.model.CargaTrabalho
import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional

data class RegistroDiarioUiState(
    val data: String = "", // preencher com a data atual depois
    val emojiSelecionado: Emoji? = null,
    val estadoEmocionalSelecionado: EstadoEmocional? = null,
    val cargaTrabalhoSelecionada: CargaTrabalho? = null,
    val registroSalvoComSucesso: Boolean = false,
    val erro: String? = null
)

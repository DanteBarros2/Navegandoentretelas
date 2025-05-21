package br.com.Stressly.domain.model

data class ResumoHumor(
    val emojiDaSemana: Emoji,
    val mediaHumorTresMeses: EstadoEmocional,
    val percentualDiasIrritado: Double,
    val percentualNoitesMalDormidas: Double,
    val distribuicaoHumor: Map<EstadoEmocional, Double>
)

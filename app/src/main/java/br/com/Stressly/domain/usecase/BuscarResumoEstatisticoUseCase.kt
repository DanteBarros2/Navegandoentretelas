package br.com.Stressly.domain.usecase

import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.domain.model.ResumoHumor
import br.com.Stressly.domain.repository.RegistroDiarioRepository

class BuscarResumoEstatisticoUseCase(
    private val repository: RegistroDiarioRepository
) {
    suspend operator fun invoke(): ResumoHumor {
        val registros = repository.listarRegistros()

        val emojiMaisFrequente = registros
            .groupingBy { it.emoji }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key ?: Emoji.FELIZ

        val mediaEstadoEmocional = registros
            .groupingBy { it.estadoEmocional }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key ?: EstadoEmocional.SATISFEITO

        val percentualIrritado = registros.count {
            it.estadoEmocional == EstadoEmocional.ESTRESSADO || it.estadoEmocional == EstadoEmocional.CANSADO
        }.toDouble() / registros.size * 100

        val distribuicao = registros
            .groupingBy { it.estadoEmocional }
            .eachCount()
            .mapValues { (it.value.toDouble() / registros.size) * 100 }

        return ResumoHumor(
            emojiDaSemana = emojiMaisFrequente,
            mediaHumorTresMeses = mediaEstadoEmocional,
            percentualDiasIrritado = percentualIrritado,
            percentualNoitesMalDormidas = 0.0, // ainda não temos esse dado
            distribuicaoHumor = distribuicao
        )
    }
}

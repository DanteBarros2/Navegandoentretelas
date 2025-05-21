package br.com.Stressly.domain.usecase

import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.domain.repository.RegistroDiarioRepository

class CalcularMediaHumorMensalUseCase(
    private val repository: RegistroDiarioRepository
) {
    suspend operator fun invoke(mes: Int, ano: Int): EstadoEmocional? {
        val registros = repository.listarRegistros().filter {
            it.data.monthValue == mes && it.data.year == ano
        }

        if (registros.isEmpty()) return null

        val maisFrequente = registros
            .groupingBy { it.estadoEmocional }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key

        return maisFrequente
    }
}

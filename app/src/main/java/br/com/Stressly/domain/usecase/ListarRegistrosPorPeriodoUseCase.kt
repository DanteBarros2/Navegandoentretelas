package br.com.Stressly.domain.usecase

import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.repository.RegistroDiarioRepository
import java.time.LocalDate

class ListarRegistrosPorPeriodoUseCase(
    private val repository: RegistroDiarioRepository
) {
    suspend operator fun invoke(inicio: LocalDate, fim: LocalDate): List<RegistroDiario> {
        return repository.listarRegistrosPorPeriodo(inicio, fim)
    }
}

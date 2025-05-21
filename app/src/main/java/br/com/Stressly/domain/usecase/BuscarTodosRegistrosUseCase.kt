package br.com.Stressly.domain.usecase

import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.repository.RegistroDiarioRepository

class BuscarTodosRegistrosUseCase(
    private val repository: RegistroDiarioRepository
) {
    suspend operator fun invoke(): List<RegistroDiario> {
        return repository.listarRegistros()
    }
}

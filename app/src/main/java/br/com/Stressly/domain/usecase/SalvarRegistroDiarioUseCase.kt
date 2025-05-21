package br.com.Stressly.domain.usecase;

import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.repository.RegistroDiarioRepository

class SalvarRegistroDiarioUseCase(
    private val repository: RegistroDiarioRepository
) {
    suspend operator fun invoke(registro: RegistroDiario) {
        repository.salvarRegistro(registro)
    }
}

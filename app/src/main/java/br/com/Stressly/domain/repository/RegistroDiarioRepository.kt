package br.com.Stressly.domain.repository

import br.com.Stressly.domain.model.RegistroDiario
import java.time.LocalDate

interface RegistroDiarioRepository {
    suspend fun salvarRegistro(registro: RegistroDiario)
    suspend fun listarRegistros(): List<RegistroDiario>
    suspend fun listarRegistrosPorPeriodo(inicio: LocalDate, fim: LocalDate): List<RegistroDiario>
    suspend fun buscarRegistroPorData(data: LocalDate): RegistroDiario?
    suspend fun buscarTodosRegistros(): List<RegistroDiario>

}

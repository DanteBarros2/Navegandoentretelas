package br.com.Stressly.data.repository

import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.repository.RegistroDiarioRepository
import java.time.LocalDate

class RegistroDiarioRepositoryImpl : RegistroDiarioRepository {

    private val registros = mutableListOf<RegistroDiario>()

    override suspend fun salvarRegistro(registro: RegistroDiario) {
        // Remove registro do mesmo dia (evita duplicatas)
        registros.removeIf { it.data == registro.data }
        registros.add(registro)
    }

    override suspend fun listarRegistros(): List<RegistroDiario> {
        return registros.toList()
    }

    override suspend fun listarRegistrosPorPeriodo(
        inicio: LocalDate,
        fim: LocalDate
    ): List<RegistroDiario> {
        return registros.filter { it.data >= inicio && it.data <= fim }
    }


    override suspend fun buscarRegistroPorData(data: LocalDate): RegistroDiario? {
        return registros.find { it.data == data }
    }

    override suspend fun buscarTodosRegistros(): List<RegistroDiario> {
        return registros.toList()
    }
}

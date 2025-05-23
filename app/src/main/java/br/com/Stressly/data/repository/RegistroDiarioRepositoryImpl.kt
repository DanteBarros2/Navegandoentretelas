package br.com.Stressly.data.repository


import br.com.Stressly.data.datasource.RegistroDiarioMapper.toDomain
import br.com.Stressly.data.datasource.RegistroDiarioMapper.toRealm
import br.com.Stressly.data.datasource.RegistroDiarioRealm
import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.repository.RegistroDiarioRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.RealmInstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class RegistroDiarioRepositoryImpl(
    private val realm: Realm
) : RegistroDiarioRepository {

    override suspend fun salvarRegistro(registro: RegistroDiario) {
        withContext(Dispatchers.IO) {
            realm.write {
                // Remove qualquer registro do mesmo dia
                val jaExistente = query<RegistroDiarioRealm>("data == $0", registro.data.toString())
                    .first()
                    .find()
                jaExistente?.let { delete(it) }

                copyToRealm(registro.toRealm())
            }
        }
    }

    override suspend fun listarRegistros(): List<RegistroDiario> {
        return withContext(Dispatchers.IO) {
            realm.query<RegistroDiarioRealm>().find().map { it.toDomain() }
        }
    }

    override suspend fun listarRegistrosPorPeriodo(
        inicio: LocalDate,
        fim: LocalDate
    ): List<RegistroDiario> {
        return withContext(Dispatchers.IO) {
            realm.query<RegistroDiarioRealm>("data >= $0 AND data <= $1", inicio.toString(), fim.toString())
                .find()
                .map { it.toDomain() }
        }
    }

    override suspend fun buscarRegistroPorData(data: LocalDate): RegistroDiario? {
        return withContext(Dispatchers.IO) {
            realm.query<RegistroDiarioRealm>("data == $0", data.toString())
                .first()
                .find()
                ?.toDomain()
        }
    }

    override suspend fun buscarTodosRegistros(): List<RegistroDiario> {
        return listarRegistros() // mesmo comportamento
    }
}


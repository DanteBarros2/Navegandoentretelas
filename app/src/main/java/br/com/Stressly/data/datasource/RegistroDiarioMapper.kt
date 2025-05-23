package br.com.Stressly.data.datasource


import br.com.Stressly.data.datasource.RegistroDiarioRealm
import br.com.Stressly.domain.model.*
import java.time.LocalDate

object RegistroDiarioMapper {

    fun RegistroDiario.toRealm(): RegistroDiarioRealm {
        return RegistroDiarioRealm().apply {
            id = this@toRealm.id
            data = this@toRealm.data.toString()
            emoji = this@toRealm.emoji.name
            estadoEmocional = this@toRealm.estadoEmocional.name
            cargaTrabalho = this@toRealm.cargaTrabalho.name
        }
    }

    fun RegistroDiarioRealm.toDomain(): RegistroDiario {
        return RegistroDiario(
            id = this.id,
            data = LocalDate.parse(this.data),
            emoji = Emoji.valueOf(this.emoji),
            estadoEmocional = EstadoEmocional.valueOf(this.estadoEmocional),
            cargaTrabalho = CargaTrabalho.valueOf(this.cargaTrabalho)
        )
    }
}


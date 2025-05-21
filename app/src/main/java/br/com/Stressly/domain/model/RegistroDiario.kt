package br.com.Stressly.domain.model

import java.time.LocalDate
import java.util.UUID

data class RegistroDiario(
    val id: String = UUID.randomUUID().toString(),
    val data: LocalDate,
    val emoji: Emoji,
    val estadoEmocional: EstadoEmocional,
    val cargaTrabalho: CargaTrabalho
)

enum class Emoji {
    TRISTE, FELIZ, EXAUSTO, MEDO, RAIVA
}

enum class EstadoEmocional {
    MOTIVADO, CANSADO, PREOCUPADO, ESTRESSADO, ANIMADO, SATISFEITO
}

enum class CargaTrabalho {
    MUITO_LEVE, LEVE, MEDIA, ALTA, MUITO_ALTA
}

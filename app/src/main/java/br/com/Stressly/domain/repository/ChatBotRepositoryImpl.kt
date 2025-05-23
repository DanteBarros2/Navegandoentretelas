package br.com.Stressly.domain.repository

import br.com.Stressly.domain.model.ChatMessage
import br.com.Stressly.domain.repository.ChatBotRepository
import java.util.UUID
import kotlinx.coroutines.delay

class ChatBotRepositoryImpl : ChatBotRepository {

    override suspend fun sendMessage(message: String): ChatMessage {
        delay(1000) // Simula tempo de resposta
        val response = generateResponse(message)
        return ChatMessage(
            id = UUID.randomUUID().toString(),
            message = response,
            isUser = false
        )
    }

    private fun generateResponse(message: String): String {
        return when {
            message.contains("estresse", ignoreCase = true) -> "Lembre-se de respirar profundamente. Você gostaria de algumas dicas para aliviar o estresse?"
            message.contains("oi", ignoreCase = true) -> "Olá! Como posso te ajudar hoje?"
            message.contains("tchau", ignoreCase = true) -> "Até logo! Cuide-se!"
            else -> "Desculpe, não entendi. Pode reformular sua pergunta?"
        }
    }
}

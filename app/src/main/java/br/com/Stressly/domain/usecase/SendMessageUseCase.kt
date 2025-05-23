package br.com.Stressly.domain.usecase

import br.com.Stressly.domain.model.ChatMessage
import br.com.Stressly.domain.repository.ChatBotRepository

class SendMessageUseCase(
    private val repository: ChatBotRepository
) {
    suspend operator fun invoke(message: String): ChatMessage {
        return repository.sendMessage(message)
    }
}
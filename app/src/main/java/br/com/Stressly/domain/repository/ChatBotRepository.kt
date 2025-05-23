package br.com.Stressly.domain.repository

import br.com.Stressly.domain.model.ChatMessage

interface ChatBotRepository {
    suspend fun sendMessage(message: String): ChatMessage
}
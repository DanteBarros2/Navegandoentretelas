package br.com.Stressly.domain.model


data class ChatMessage(
    val id: String = "",
    val message: String,
    val isUser: Boolean
)

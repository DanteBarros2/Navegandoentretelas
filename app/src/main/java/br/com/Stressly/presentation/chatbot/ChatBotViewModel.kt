package br.com.Stressly.presentation.chatbot


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.Stressly.domain.model.ChatMessage
import br.com.Stressly.domain.usecase.SendMessageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class ChatBotViewModel(
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    fun sendMessage(userMessage: String) {
        val userChat = ChatMessage(
            id = UUID.randomUUID().toString(),
            message = userMessage,
            isUser = true
        )
        _messages.value = _messages.value + userChat

        viewModelScope.launch {
            val response = sendMessageUseCase(userMessage)
            _messages.value = _messages.value + response
        }
    }
}
import br.com.Stressly.domain.model.ChatMessage
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatBotApiService {
    @POST("chatbot/sendMessage")
    suspend fun sendMessage(@Body userMessage: ChatMessage): ChatMessage
}
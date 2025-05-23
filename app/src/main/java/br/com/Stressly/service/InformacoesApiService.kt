import br.com.Stressly.presentation.informacoes.InformacoesUiState
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Body

interface InformacoesApiService {
    @GET("informacoes")
    suspend fun getInformacoes(): InformacoesUiState

    @PUT("informacoes")
    suspend fun updateInformacoes(@Body novoEstado: InformacoesUiState): InformacoesUiState
}
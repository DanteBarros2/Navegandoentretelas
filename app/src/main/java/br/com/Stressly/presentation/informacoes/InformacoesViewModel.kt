package br.com.Stressly.presentation.informacoes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class InformacoesUiState(
    val textos: List<String> = emptyList()
)

class InformacoesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        InformacoesUiState(
            textos = listOf(
                "🔴 Por que monitorar o estresse é essencial?\n\nNa correria do dia a dia, é comum ignorarmos os sinais que o corpo e a mente nos enviam. No entanto, níveis elevados e prolongados de estresse podem ter sérias consequências para a saúde física, mental e emocional...",
                "⚪ O que é o burnout?\n\nO burnout é caracterizado por exaustão emocional, perda de motivação e redução da produtividade...",
                "🟢 O papel do monitoramento\n\nMonitorar os níveis de estresse é o primeiro passo para prevenir o burnout. Com o Stressly, você pode acompanhar os seus níveis diariamente...",
                "🟡 Prevenção e autocuidado\n\nAo entender seus gatilhos de estresse, você ganha mais clareza sobre sua rotina, aprende a melhorar sua saúde mental e pode aplicar estratégias para se manter saudável...",
                "🔵 Com o Stressly, você cuida da sua saúde mental todos os dias.\n\nEntenda. Acompanhe. Previna."
            )
        )
    )
    val uiState: StateFlow<InformacoesUiState> = _uiState
}
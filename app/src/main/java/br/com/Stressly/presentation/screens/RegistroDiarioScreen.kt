package br.com.Stressly.presentation.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.Stressly.domain.model.CargaTrabalho
import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.presentation.registrodiario.RegistroDiarioViewModel

@Composable
fun RegistroDiarioScreen(viewModel: RegistroDiarioViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Como você se sente hoje?", style = MaterialTheme.typography.headlineSmall)

        // Emojis
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Emoji.values().forEach { emoji ->
                Text(
                    text = emoji.name,
                    modifier = Modifier
                        .clickable { viewModel.selecionarEmoji(emoji) }
                        .padding(8.dp),
                    color = if (uiState.emojiSelecionado == emoji) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            }
        }

        // Estado emocional
        DropdownMenuSection(
            label = "Estado emocional",
            options = EstadoEmocional.values().toList(),
            selected = uiState.estadoEmocionalSelecionado,
            onSelect = { viewModel.selecionarEstadoEmocional(it) }
        )

        // Carga de trabalho
        DropdownMenuSection(
            label = "Carga de trabalho",
            options = CargaTrabalho.values().toList(),
            selected = uiState.cargaTrabalhoSelecionada,
            onSelect = { viewModel.selecionarCargaTrabalho(it) }
        )

        // Botão salvar
        Button(onClick = { viewModel.salvarRegistro() }) {
            Text("Salvar registro")
        }

        // Feedback
        if (uiState.registroSalvoComSucesso) {
            Text(text = "Registro salvo com sucesso!", color = MaterialTheme.colorScheme.primary)
        }

        if (uiState.erro != null) {
            Text(text = uiState.erro ?: "", color = MaterialTheme.colorScheme.error)
        }
    }
}

@Composable
fun <T> DropdownMenuSection(
    label: String,
    options: List<T>,
    selected: T?,
    onSelect: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(text = label)
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(text = selected?.toString() ?: "Selecionar")
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.toString()) },
                        onClick = {
                            onSelect(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

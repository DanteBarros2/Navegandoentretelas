package br.com.Stressly.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.navegandoentretelas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformacoesScreen(
    onVoltarClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Informações") },
                navigationIcon = {
                    IconButton(onClick = onVoltarClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Imagem principal
            Image(
                painter = painterResource(id = R.drawable.imgemstress), // Substituir pelo seu drawable
                contentDescription = "Imagem de estresse",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Card com informações
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    InfoSection(
                        title = "🔴 Por que monitorar o estresse é essencial?",
                        description = "Na correria do dia a dia, é comum ignorarmos os sinais que o corpo e a mente nos enviam. No entanto, níveis elevados e prolongados de estresse podem ter sérias consequências para a saúde física, mental e emocional..."
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    InfoSection(
                        title = "⚪ O que é o burnout?",
                        description = "O burnout é caracterizado por exaustão emocional, perda de motivação e redução da produtividade..."
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    InfoSection(
                        title = "🟢 O papel do monitoramento",
                        description = "Monitorar os níveis de estresse é o primeiro passo para prevenir o burnout. Com o Stressly, você pode acompanhar os seus níveis diariamente..."
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    InfoSection(
                        title = "🟡 Prevenção e autocuidado",
                        description = "Ao entender seus gatilhos de estresse, você ganha mais clareza sobre sua rotina, aprende a melhorar sua saúde mental e pode aplicar estratégias para se manter saudável..."
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    InfoSection(
                        title = "🔵 Com o Stressly, você cuida da sua saúde mental todos os dias.",
                        description = "Entenda. Acompanhe. Previna."
                    )
                }
            }
        }
    }
}

@Composable
fun InfoSection(title: String, description: String) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            fontSize = 14.sp
        )
    }
}

package br.com.Stressly.presentation.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.navegandoentretelas.R


@Composable
fun TelaInicialStresslyScreen(
    onEntrarClick: () -> Unit,
    onInformacoesClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagem do logo
        Image(
            painter = painterResource(id = R.drawable.logo_stressly),
            contentDescription = "Logo do Stressly",
            modifier = Modifier
                .height(200.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Fit
        )

        // Nome do app
        Text(
            text = "Stressly",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D253C)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Frases
        Text(
            text = "Acompanhe.",
            fontSize = 16.sp,
            color = Color(0xFF4D9DA5),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Entenda.",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "Previna.",
            fontSize = 16.sp,
            color = Color(0xFF4D9DA5),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Viva melhor com o\nStressly...",
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botão Entrar
        Button(
            onClick = onEntrarClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE0E0E0)
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        ) {
            Text(
                text = "Entrar",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão Informações
        OutlinedButton(
            onClick = onInformacoesClick,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        ) {
            Text(
                text = "Informações",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


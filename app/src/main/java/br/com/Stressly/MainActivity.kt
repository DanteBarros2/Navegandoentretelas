package br.com.Stressly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
//import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.Stressly.data.repository.RegistroDiarioRepositoryImpl
import br.com.Stressly.domain.usecase.SalvarRegistroDiarioUseCase
import br.com.Stressly.presentation.registrodiario.RegistroDiarioViewModel
import br.com.Stressly.presentation.screens.LoginScreen
import br.com.Stressly.presentation.screens.MenuScreen
import br.com.Stressly.presentation.screens.PedidosScreen
import br.com.Stressly.presentation.screens.PerfilScreen
import br.com.Stressly.presentation.screens.RegistroDiarioScreen
import br.com.Stressly.ui.theme.NavegandoEntreTelasTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegandoEntreTelasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = RegistroDiarioViewModel(
                        SalvarRegistroDiarioUseCase(
                            RegistroDiarioRepositoryImpl()
                        )
                    )
                    RegistroDiarioScreen(viewModel)


                }
            }
        }
    }
}


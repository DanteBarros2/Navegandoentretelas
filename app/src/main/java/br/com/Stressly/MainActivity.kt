package br.com.Stressly

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.Stressly.data.datasource.RegistroDiarioRealm
import br.com.Stressly.data.repository.RegistroDiarioRepositoryImpl
import br.com.Stressly.domain.model.CargaTrabalho
import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.usecase.BuscarTodosRegistrosUseCase
import br.com.Stressly.domain.usecase.SalvarRegistroDiarioUseCase
import br.com.Stressly.presentation.registrodiario.RegistroDiarioViewModel
import br.com.Stressly.presentation.screens.InformacoesScreen
import br.com.Stressly.presentation.screens.RegistroDiarioScreen
import br.com.Stressly.presentation.screens.TelaInicialStresslyScreen
import br.com.Stressly.ui.theme.NavegandoEntreTelasTheme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavegandoEntreTelasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    // Banco Realm
                    val realm = Realm.open(
                        RealmConfiguration.create(
                            schema = setOf(RegistroDiarioRealm::class)
                        )
                    )
                    val repository = RegistroDiarioRepositoryImpl(realm)

                    val salvar = SalvarRegistroDiarioUseCase(repository)
                    val buscarTodos = BuscarTodosRegistrosUseCase(repository)

                    // Teste opcional no banco
                    CoroutineScope(Dispatchers.IO).launch {
                        val registro = RegistroDiario(
                            data = LocalDate.now(),
                            emoji = Emoji.FELIZ,
                            estadoEmocional = EstadoEmocional.ANIMADO,
                            cargaTrabalho = CargaTrabalho.MEDIA
                        )
                        salvar(registro)

                        val todos = buscarTodos()
                        Log.d("Stressly", "Todos os registros: $todos")
                    }

                    // Navegação
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "tela_inicial"
                    ) {

                        // Tela inicial
                        composable("tela_inicial") {
                            TelaInicialStresslyScreen(
                                onEntrarClick = {
                                    navController.navigate("registro_diario")
                                },
                                onInformacoesClick = {
                                    navController.navigate("informacoes")
                                }
                            )
                        }

                        // Tela de registro diário
                        composable("registro_diario") {
                            RegistroDiarioScreen(
                                viewModel = RegistroDiarioViewModel(
                                    salvarRegistroDiarioUseCase = salvar
                                )
                            )
                        }

                        // Tela de informações
                        composable("informacoes") {
                            InformacoesScreen(
                                onVoltarClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
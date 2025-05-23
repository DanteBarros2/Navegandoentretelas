package br.com.Stressly

import android.annotation.SuppressLint
import android.util.Log
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.Stressly.data.datasource.RegistroDiarioRealm
import br.com.Stressly.data.repository.RegistroDiarioRepositoryImpl
import br.com.Stressly.domain.model.CargaTrabalho
import br.com.Stressly.domain.model.Emoji
import br.com.Stressly.domain.model.EstadoEmocional
import br.com.Stressly.domain.model.RegistroDiario
import br.com.Stressly.domain.usecase.BuscarTodosRegistrosUseCase
import br.com.Stressly.domain.usecase.SalvarRegistroDiarioUseCase
import br.com.Stressly.presentation.registrodiario.RegistroDiarioViewModel
import br.com.Stressly.presentation.screens.RegistroDiarioScreen
import br.com.Stressly.ui.theme.NavegandoEntreTelasTheme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegandoEntreTelasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    val realm =
                        Realm.open(RealmConfiguration.create(schema = setOf(RegistroDiarioRealm::class)))
                    val repository = RegistroDiarioRepositoryImpl(realm)

                    val salvar = SalvarRegistroDiarioUseCase(repository)
                    val buscarTodos = BuscarTodosRegistrosUseCase(repository)

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

                    RegistroDiarioScreen(RegistroDiarioViewModel(salvarRegistroDiarioUseCase = salvar))
                }
            }
        }
    }
}



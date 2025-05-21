import br.com.Stressly.data.repository.RegistroDiarioRepositoryImpl
import br.com.Stressly.domain.model.*
import br.com.Stressly.domain.usecase.*
import kotlinx.coroutines.runBlocking
import java.time.LocalDate

fun main() = runBlocking {
    // Instancia o repositório fake em memória
    val repository = RegistroDiarioRepositoryImpl()

    // Use cases
    val salvarRegistro = SalvarRegistroDiarioUseCase(repository)
    val buscarPorData = BuscarRegistroPorDataUseCase(repository)
    val buscarTodos = BuscarTodosRegistrosUseCase(repository)
    val listarPorPeriodo = ListarRegistrosPorPeriodoUseCase(repository)

    // Cria e salva um registro
    val registroHoje = RegistroDiario(
        data = LocalDate.now(),
        emoji = Emoji.FELIZ,
        estadoEmocional = EstadoEmocional.ANIMADO,
        cargaTrabalho = CargaTrabalho.MEDIA
    )

    salvarRegistro(registroHoje)

    // Busca por data
    val resultadoHoje = buscarPorData(LocalDate.now())
    println("Registro de hoje: $resultadoHoje")

    // Busca todos
    val todos = buscarTodos()
    println("Todos os registros: $todos")

    // Adiciona mais um registro
    val registroOntem = registroHoje.copy(data = LocalDate.now().minusDays(1), emoji = Emoji.TRISTE)
    salvarRegistro(registroOntem)

    // Listar por período
    val ultimos2Dias = listarPorPeriodo(LocalDate.now().minusDays(2), LocalDate.now())
    println("Registros dos últimos 2 dias: $ultimos2Dias")
}

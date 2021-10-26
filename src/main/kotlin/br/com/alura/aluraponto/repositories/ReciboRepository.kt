package br.com.alura.aluraponto.repositories

import br.com.alura.aluraponto.models.Localizacao
import br.com.alura.aluraponto.models.Recibo
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class ReciboRepository {

    private val _recibos = mutableListOf(
        Recibo(
            status = true,
            data = LocalDateTime.now(),
            localizacao = Localizacao(
                "1",
                "1"
            )
        )
    )

    val recibos: List<Recibo> get() = _recibos.toList()

    fun save(recibo: Recibo): Recibo {
        return recibo.copy(status = true).also {
            _recibos.add(it)
        }
    }

    fun delete(id: UUID) {
        _recibos.removeIf {
            it.id == id
        }
    }

}

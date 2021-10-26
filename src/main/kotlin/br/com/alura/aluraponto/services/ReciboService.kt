package br.com.alura.aluraponto.services

import br.com.alura.aluraponto.models.Recibo
import br.com.alura.aluraponto.repositories.ReciboRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReciboService(
    private val repository: ReciboRepository
) {

    fun findAll(): Iterable<Recibo> {
        return repository.findAll()
    }

    fun save(recibo: Recibo): Recibo {
        return repository.save(
            Recibo(
                id = recibo.id,
                status = true,
                data = recibo.data,
                localizacao = recibo.localizacao
            )
        )
    }

    fun delete(id: UUID) {
        repository.deleteById(id)
    }
}

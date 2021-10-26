package br.com.alura.aluraponto.services

import br.com.alura.aluraponto.models.Recibo
import br.com.alura.aluraponto.repositories.ReciboRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReciboService(
    private val repository: ReciboRepository
) {

    fun findAll(): List<Recibo> {
        return repository.recibos
    }

    fun save(recibo: Recibo): Recibo {
        return repository.save(recibo)
    }

    fun delete(id: UUID) {
        repository.delete(id)
    }
}

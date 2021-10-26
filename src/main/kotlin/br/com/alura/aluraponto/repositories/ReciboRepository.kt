package br.com.alura.aluraponto.repositories

import br.com.alura.aluraponto.models.Recibo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReciboRepository : CrudRepository<Recibo, UUID>

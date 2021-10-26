package br.com.alura.aluraponto.models

import java.time.LocalDateTime
import java.util.*

data class Recibo(
    val id: UUID = UUID.randomUUID(),
    val status: Boolean,
    val data: LocalDateTime,
    val localizacao: Localizacao
)

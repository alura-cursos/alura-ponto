package br.com.alura.aluraponto.models

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Recibo(
    @Id
    val id: UUID = UUID.randomUUID(),
    val status: Boolean = false,
    val data: LocalDateTime = LocalDateTime.now(),
    @Embedded
    val localizacao: Localizacao? = null
)

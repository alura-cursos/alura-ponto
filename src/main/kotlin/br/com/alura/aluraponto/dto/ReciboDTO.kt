package br.com.alura.aluraponto.dto

import br.com.alura.aluraponto.models.Localizacao
import br.com.alura.aluraponto.models.Recibo
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.*

class ReciboResponse(
    recibo: Recibo,
    val id: UUID = recibo.id,
    val status: Boolean = recibo.status,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    val data: LocalDateTime = recibo.data,
    val localizacao: Localizacao? = recibo.localizacao
)

class ReciboRequest(
    id: UUID = UUID.randomUUID(),
    status: Boolean,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    data: LocalDateTime,
    localizacao: Localizacao?
) {
    val recibo: Recibo = Recibo(
        id, status, data, localizacao
    )
}
package br.com.alura.aluraponto.controllers

import br.com.alura.aluraponto.dto.ReciboRequest
import br.com.alura.aluraponto.dto.ReciboResponse
import br.com.alura.aluraponto.services.ReciboService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("recibos")
class RecibosController(
    private val service: ReciboService
) {

    @GetMapping
    fun allRecibos(): ResponseEntity<List<ReciboResponse>> {
        return service.findAll().map {
            ReciboResponse(it)
        }.run {
            ResponseEntity.ok(this)
        }
    }

    @PostMapping
    fun save(@RequestBody request: ReciboRequest): ResponseEntity<ReciboResponse> {
        return ResponseEntity.ok(
            ReciboResponse(
                service.save(request.recibo)
            )
        )
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Any> {
        return try {
            service.delete(id)
            ResponseEntity.ok().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

}
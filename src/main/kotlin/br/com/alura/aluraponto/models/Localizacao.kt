package br.com.alura.aluraponto.models

class Localizacao(
    val latitude: String? = null,
    val longitude: String? = null
) {
    override fun toString(): String {
        return "Localizacao(latitude=$latitude, longitude=$longitude)"
    }
}

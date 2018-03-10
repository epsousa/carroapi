package br.com.evairsousa.carroapi.repository

import br.com.evairsousa.carroapi.entity.Carro
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarroRepository : MongoRepository<Carro, String> {

    fun findByAno(ano: Int): List<Carro>

    fun findByMarcaContaining(marca: String): List<Carro>

    fun findByPlaca(placa: Int): Carro

}
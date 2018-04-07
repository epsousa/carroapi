package br.com.evairsousa.carroapi.repository


import br.com.evairsousa.carroapi.entity.Produto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : MongoRepository<Produto, String> {

    fun findByNome(nome: String): List<Produto>

    fun findByNomeContaining(nome: String): List<Produto>

    fun findById(id: Int): Produto

}
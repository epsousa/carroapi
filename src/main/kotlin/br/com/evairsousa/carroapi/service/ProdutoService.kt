package br.com.evairsousa.carroapi.service

import br.com.evairsousa.carroapi.entity.Produto
import br.com.evairsousa.carroapi.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService {

    @Autowired
    lateinit var produtoRepository: ProdutoRepository

    fun buscarProdutoPorNome(nome: String): List<Produto> {
        return this.produtoRepository.findByNome(nome)
    }

    fun buscarProdutoPorNomeContido(nome: String): List<Produto> {
        return this.produtoRepository.findByNomeContaining(nome)
    }

    fun buscarProdutoPorId(id: Int): Produto {
        return this.produtoRepository.findById(id)
    }

    fun salvar(produto: Produto) {
        this.produtoRepository.save(produto);
    }

    fun buscarTodosProdutos(): List<Produto>{
        return this.produtoRepository.findAll()
    }

}
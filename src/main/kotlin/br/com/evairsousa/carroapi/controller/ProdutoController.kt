package br.com.evairsousa.carroapi.controller

import br.com.evairsousa.carroapi.entity.Produto
import br.com.evairsousa.carroapi.service.ProdutoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produto")
class ProdutoController {

    @Autowired
    lateinit var produtoService: ProdutoService

    @GetMapping
    fun buscarTodos(): List<Produto> {
        return this.produtoService.buscarTodosProdutos()
    }

    @PostMapping
    fun salvar(@RequestBody produto: Produto) {
        produtoService.salvar(produto);
    }

}
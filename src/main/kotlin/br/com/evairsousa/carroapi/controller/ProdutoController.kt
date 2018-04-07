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

    @GetMapping
    @RequestMapping("/{nome}")
    fun buscarPorNome(@PathVariable("nome") nome: String): List<Produto> {
        return this.produtoService.buscarProdutoPorNome(nome)
    }
    @GetMapping
    @RequestMapping("/{nome}/aproximado")
    fun buscarPorNomeAproximado(@PathVariable("nome") nome: String): List<Produto> {
        return this.produtoService.buscarProdutoPorNomeContido(nome)
    }

    @PostMapping
    fun salvar(@RequestBody produto: Produto) {
        produtoService.salvar(produto);
    }

    @PutMapping
    fun alterar(@RequestBody produto: Produto) {
        produtoService.alterar(produto);
    }

    @DeleteMapping
    fun deletar(@RequestBody produto: Produto) {
        produtoService.deletar(produto);
    }

}
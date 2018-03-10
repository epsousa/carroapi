package br.com.evairsousa.carroapi.controller

import br.com.evairsousa.carroapi.entity.Carro
import br.com.evairsousa.carroapi.service.CarroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carro")
class CarroController {

    @Autowired
    lateinit var carroService: CarroService

    @GetMapping
    fun buscarTodos(): List<Carro> {
        return this.carroService.buscarTodosCarros();
    }

    @PostMapping
    fun salvar(@RequestBody carro: Carro) {
        carroService.salvar(carro);
    }

}
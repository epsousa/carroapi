package br.com.evairsousa.carroapi.service

import br.com.evairsousa.carroapi.entity.Carro
import br.com.evairsousa.carroapi.repository.CarroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarroService {

    @Autowired
    lateinit var carroRepository: CarroRepository

    fun buscarCarroPorMarca(marca: String): List<Carro> {
        return this.carroRepository.findByMarcaContaining(marca)
    }

    fun buscarCarroPorAno(ano: Int): List<Carro> {
        return this.carroRepository.findByAno(ano)
    }

    fun buscarCarroPorPlaca(placa: Int): Carro {
        return this.carroRepository.findByPlaca(placa)
    }

    fun salvar(carro: Carro) {
        this.carroRepository.save(carro);
    }

    fun buscarTodosCarros(): List<Carro>{
        return this.carroRepository.findAll()
    }

}
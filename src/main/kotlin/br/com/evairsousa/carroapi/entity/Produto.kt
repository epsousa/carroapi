package br.com.evairsousa.carroapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Produto(@Id var id: String?,
                 var nome: String,
                 var categoria: String,
                 var preco: Double,
                 var urlImagem: String?) {

//    constructor():this("","", "", 0, "")


}
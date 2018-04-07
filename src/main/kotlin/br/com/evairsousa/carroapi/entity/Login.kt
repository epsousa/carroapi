package br.com.evairsousa.carroapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Login(@Id var id: String?,
                   var nome: String,
                   var senha: String,
                   var email: String) {

//    constructor():this("","", "", 0, "")


}
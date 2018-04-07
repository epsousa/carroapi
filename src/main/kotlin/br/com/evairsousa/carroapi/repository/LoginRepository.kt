package br.com.evairsousa.carroapi.repository

import br.com.evairsousa.carroapi.entity.Login
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LoginRepository : MongoRepository<Login, String> {

    fun findById(id: Int): Login

    fun findByEmail(email:String): List<Login>

}
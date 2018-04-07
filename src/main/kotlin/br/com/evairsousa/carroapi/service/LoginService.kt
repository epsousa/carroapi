package br.com.evairsousa.carroapi.service

import br.com.evairsousa.carroapi.entity.Login
import br.com.evairsousa.carroapi.repository.LoginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    lateinit var loginRepository: LoginRepository

    fun salvar(login: Login) {
        this.loginRepository.save(login);
    }

    fun login(login: Login): Login{

        var retorno = loginRepository.findByEmail(login.email)

        if(retorno.isNotEmpty()) {
            if (retorno.get(0).senha.equals(login.senha)) {
                return retorno.get(0)
            } else {
                return Login("", "", "", "")
            }
        } else {
            return Login("", "", "", "")
        }
    }

}
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

        if(login.email.isNullOrBlank()){
            throw Exception("Email deve ser preenchido")
        } else if(!login.email.contains(Regex("(\\w+@\\w+\\.\\w+)(\\.\\w+)?"))){
            throw Exception("Email deve ser preenchido de acordo com exemplo: exemplo@exemplo.com")
        }

        if(login.nome.isNullOrBlank()){
            throw Exception("Nome deve ser preenchido")
        }

        if(login.senha.isNullOrBlank()){
            throw Exception("Senha deve ser preenchido")
        }

        if(loginRepository.findByEmail(login.email).isNotEmpty()){
            throw Exception("Email já cadastrado.")
        }

        this.loginRepository.save(login)
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
package br.com.evairsousa.carroapi.controller


import br.com.evairsousa.carroapi.entity.Login
import br.com.evairsousa.carroapi.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
class LoginController {

    @Autowired
    lateinit var loginService: LoginService

    @PostMapping
    @RequestMapping("/authenticate")
    fun login(@RequestBody login:Login): Login {
        return this.loginService.login(login)
    }

    @PostMapping
    fun salvar(@RequestBody login: Login) {
        loginService.salvar(login)
    }

}
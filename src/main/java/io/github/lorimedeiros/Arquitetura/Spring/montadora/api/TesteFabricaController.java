package io.github.lorimedeiros.Arquitetura.Spring.montadora.api;

import io.github.lorimedeiros.Arquitetura.Spring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteFabricaController {

    @Autowired //"Spring vá lá no seu container e me dê uma instancia de motor", no caso, aquela instancia que temos lá em MontadoraConfig
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaCivic(motor);
        return carro.darIgnicao(chave);
    }

}

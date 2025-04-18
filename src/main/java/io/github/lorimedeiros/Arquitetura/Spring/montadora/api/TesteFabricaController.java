package io.github.lorimedeiros.Arquitetura.Spring.montadora.api;

import io.github.lorimedeiros.Arquitetura.Spring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired //"Spring vá lá no seu container e me dê uma instancia de motor", no caso, aquela instancia que temos lá em MontadoraConfig
    //@Qualifier("motorAspirado") //para definir construtor caso exista mais de um
    @Aspirado //uso prático da nossa notação personalizada (equivalente a mesma linha de cima)
    private Motor motorA;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaCivic(motorA);
        return carro.darIgnicao(chave);
    }

    /*
    no body da requisição:
    {
        "tipo": "canivete",
        "montadora": "HONDA"
    }
    */

}

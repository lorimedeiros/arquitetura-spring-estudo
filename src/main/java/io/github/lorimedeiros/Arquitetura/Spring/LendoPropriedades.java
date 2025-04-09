package io.github.lorimedeiros.Arquitetura.Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LendoPropriedades {

    //lendo propriedades com @Value

    @Value("${spring.jpa.show_sql}")
    private String jpa;

    @Value("${spring.application.name}")
    private String nome;

    public String imprimirDados(){
        return "jpa: " + jpa + " nome: " + nome;
    }

}

package io.github.lorimedeiros.Arquitetura.Spring.montadora.configuration;

import io.github.lorimedeiros.Arquitetura.Spring.montadora.Motor;
import io.github.lorimedeiros.Arquitetura.Spring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

//Classes de configuração fazem definições de beans que são componentes complexos que configuramos uma vez mas
//usamos várias vezes dentro da aplicação, como configurações com bancos de dados, um servidor de emails e outros.

//objetos construídos nessa classe são beans, como o motor ali em baixo
    @Bean
    public Motor motor(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    /*
    Um bean é um objeto gerenciado pelo container Spring (IoC Container). Ele é criado, configurado e
    montado automaticamente pelo Spring, seguindo as regras definidas por você. Quando você cria um bean em
    uma classe de configuração (com @Configuration), está dizendo ao Spring: "Ei, gerencie este objeto para mim!".

    Pode ser injetado em outros beans usando @Autowired. (injeção de dependência)
    */

}

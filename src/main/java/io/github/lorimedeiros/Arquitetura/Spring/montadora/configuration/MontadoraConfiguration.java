package io.github.lorimedeiros.Arquitetura.Spring.montadora.configuration;

import io.github.lorimedeiros.Arquitetura.Spring.montadora.Motor;
import io.github.lorimedeiros.Arquitetura.Spring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

//Classes de configuração fazem definições de beans que são componentes complexos que configuramos uma vez mas
//usamos várias vezes dentro da aplicação, como configurações com bancos de dados, um servidor de emails e outros.

//objetos construídos nessa classe são beans, como o motor ali em baixo
    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }


    //Criação de mais beans de motor para testar o funcionamento de autowired com multiplos construtores
    //names também adicionados posteriormente (não são obrigatórios pois tem o mesmo nome do método, mas estão aqui para exemplificar)
    @Bean(name = "motorEletrico")
    @Primary //usado para informar que esse é o construtor primário (em caso de ter mais de um construtor para o mesmo objeto e caso o dev não informe com qualified)
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-40");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }

    /*
    Um bean é um objeto gerenciado pelo container Spring (IoC Container). Ele é criado, configurado e
    montado automaticamente pelo Spring, seguindo as regras definidas por você. Quando você cria um bean em
    uma classe de configuração (com @Configuration), está dizendo ao Spring: "Ei, gerencie este objeto para mim!".

    Pode ser injetado em outros beans usando @Autowired. (injeção de dependência)
    */

}

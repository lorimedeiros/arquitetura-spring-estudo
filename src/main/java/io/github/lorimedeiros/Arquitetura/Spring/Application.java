package io.github.lorimedeiros.Arquitetura.Spring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

// Shift + F6: para renomear "ArquiteturaSpringApplication" para "Application",
// é mais comum ser assim em projetos e esse atalho também muda esse termo quando citado em outras classes.

// essa classe funciona da forma que vem gerada pelo initializr. mas existem coisinhas que podemos fazer nela, isso que vou testar
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		//run da applic
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.profiles("producao"); //definindo perfil como sendo produção
		//builder.profiles("producao", "homologação"); //ppssivel usar 2 perfis
		builder.bannerMode(Banner.Mode.OFF); //Certas empresas não permitem o banner sping, esse comando remove o mesmo

		builder.run(args);

		ConfigurableApplicationContext applicationContext = builder.context(); //instanciando applicationContext
		//var produtoRepository = applicationContext.getBean("ProdutoRepository"); //obter um bean


		//obter nome da aplicação
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + applicationName);

		LendoPropriedades valor = applicationContext.getBean(LendoPropriedades.class);
		System.out.println(valor.imprimirDados());

	}
}

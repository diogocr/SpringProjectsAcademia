package acc.br.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Anota��o do Spring MVC que indica que nossa classe � um controller web que aceita requisi��es.
@RestController
//Esta anota��o ativa o recurso de configura��o autom�tica do m�dulo de inicializa��o do springboot (ou seja, configura��o baseada em java e verifica��o de componente)
@SpringBootApplication
public class MyApplication {
	@RequestMapping("/") // Anota��o do Spring MVC que prov� informa��o sobre roteamento da nossa aplica��o. Indica ao Spring que qualquer requisi��o HTTP feita ao �/� deve ser atendida pelo m�todo �home�.
	String home() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
	}

}

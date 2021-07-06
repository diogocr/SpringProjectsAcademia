package acc.br.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Anotação do Spring MVC que indica que nossa classe é um controller web que aceita requisições.
@RestController
//Esta anotação ativa o recurso de configuração automática do módulo de inicialização do springboot (ou seja, configuração baseada em java e verificação de componente)
@SpringBootApplication
public class MyApplication {
	@RequestMapping("/") // Anotação do Spring MVC que provê informação sobre roteamento da nossa aplicação. Indica ao Spring que qualquer requisição HTTP feita ao “/” deve ser atendida pelo método “home”.
	String home() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
	}

}

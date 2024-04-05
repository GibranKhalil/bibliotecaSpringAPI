package br.com.bibliotecaspring.bibliotecaSpring;

import br.com.bibliotecaspring.bibliotecaSpring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
	}
}

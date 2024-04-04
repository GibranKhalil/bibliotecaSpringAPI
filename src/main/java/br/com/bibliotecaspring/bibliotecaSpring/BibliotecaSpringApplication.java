package br.com.bibliotecaspring.bibliotecaSpring;

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
		var numero1 = 2;
		var numero2 = 3;
		double soma = numero2 + numero1;

		System.out.println("Essa é a soma de 2 + 3: " + soma);
	}
}

package br.com.bibliotecaspring.bibliotecaSpring;

import br.com.bibliotecaspring.bibliotecaSpring.principal.Principal;
import jdk.jfr.Registered;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
public class BibliotecaSpringApplication implements  CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal =  new Principal();
		principal.executar();
	}
}

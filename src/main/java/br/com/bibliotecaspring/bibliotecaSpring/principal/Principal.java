package br.com.bibliotecaspring.bibliotecaSpring.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    public void exibeMenu(){

        System.out.println("Digite o nome do livro para busca: ");
        var nomeLivro = leitura.nextLine();
        System.out.println("Você escolheu o livro: " + nomeLivro);
    }
}

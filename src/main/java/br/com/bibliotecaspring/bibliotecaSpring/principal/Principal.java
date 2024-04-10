package br.com.bibliotecaspring.bibliotecaSpring.principal;

import br.com.bibliotecaspring.bibliotecaSpring.models.*;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConsumoAPI;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.googleapis.com/books/v1/volumes?q=";
    private final String API_KEY = "AIzaSyAVfXqFmSp0yuY4hbRvqI9S3c8VHv1p71M";

    public void executar() {
        while (true) {
            String livro = obterLivroUsuario();
            List<DadosLivro> livros = buscarLivros(livro);
            exibirLivros(livros);
            int opcao = selecionarLivro(livros);
            leitura.nextLine();
            if (opcao == 2) {
                break;
            }
        }
    }

    private String obterLivroUsuario() {
        System.out.println("Digite o livro procurado");
        return leitura.nextLine();
    }

    private List<DadosLivro> buscarLivros(String livro) {
        String url = ENDERECO + livro.replace(" ", "+") + "&key=" + API_KEY;
        String json = consumo.obterDados(url);
        DadosBusca dadosBusca = conversor.obterDados(json, DadosBusca.class);
        return dadosBusca.items().stream().map(DadosItem::volumeInfo).collect(Collectors.toList());
    }

    private void exibirLivros(List<DadosLivro> livros) {
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("[" + i + "] " + livros.get(i).titulo());
        }
    }

    private int selecionarLivro(List<DadosLivro> livros) {
        System.out.println("Selecione um livro para ver mais detalhes:");
        int opcao = leitura.nextInt();
        leitura.nextLine();
        if (opcao < 0 || opcao >= livros.size()) {
            System.out.println("Opção inválida!");
            return -1;
        }
        Livro livroSelecionado = new Livro(livros.get(opcao).titulo(), livros.get(opcao).autores().get(0), livros.get(opcao).descricao());
        System.out.println(livroSelecionado);
        System.out.println("\nDeseja fazer uma nova busca?");
        System.out.println("(1) Sim");
        System.out.println("(2) Não");
        return leitura.nextInt();
    }
}

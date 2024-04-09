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
    List<Estante> estantes = new ArrayList<>();
    public void exibeMenu(){
        System.out.println("Digite o livro procurado");
        var livro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + livro.replace(" ", "+") + "&key=" + API_KEY);
        DadosBusca dadosBusca = conversor.obterDados(json, DadosBusca.class);

        dadosBusca.items().forEach(e -> System.out.println(e.volumeInfo().titulo()));
    }
}

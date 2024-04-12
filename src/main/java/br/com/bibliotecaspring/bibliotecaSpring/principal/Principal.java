package br.com.bibliotecaspring.bibliotecaSpring.principal;

import br.com.bibliotecaspring.bibliotecaSpring.models.*;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConsumoAPI;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    private Scanner leitura = new Scanner(System.in); //Scanner para leitura dos valores passados via terminal
    private ConsumoAPI consumo = new ConsumoAPI(); //Inicialização da classe para consumir a API que será passado
    private ConverteDados conversor = new ConverteDados(); //Inicialização da classe para converter o JSON na classe que será passada
    private final String ENDERECO = "https://www.googleapis.com/books/v1/volumes?q="; //Endereço base da api
    private final String API_KEY = "AIzaSyAVfXqFmSp0yuY4hbRvqI9S3c8VHv1p71M"; //Chave de acesso da API;
    private List<Estante> estantes = new ArrayList<>(); //Lista com todas as estantes agrupadas, exceto as que se seguem abaixo dela:
    private Estante favoritos = new Estante("Favoritos", "Estante de livros favoritos"); //Estante de favoritos
    private Estante livrosLidos =  new Estante("Livros marcados como lidos",  "Estante de livros lidos"); //Estante de livros marcados como já ldiso
    private Estante livrosSalvos = new Estante("Livros salvos", "Estante de livros salvos"); //Estante de livros msalvos

    public void executar() {
        var opcao = 0;
        while (opcao!=8){
            opcao = exibirMenuPrincipal();
            switch (opcao){
                case 1:
                    String livro = obterLivroUsuario();
                    List<DadosLivro> livros = buscarLivros(livro);
                    exibirLivros(livros);
                    Livro livroSelecionado = selecionarLivro(livros);
                    acaoLivroSelecionado(livroSelecionado);
                    break;
                case 2:
                    criarEstante();
                    break;
                case 3:
                    if(!estantes.isEmpty()){
                        System.out.println("Digite o nome da estante");
                        String nomeEstante = leitura.nextLine();
                        Estante estanteBuscada = buscarEstante(nomeEstante);
                        if(estanteBuscada != null){
                            System.out.println(estanteBuscada);
                            estanteBuscada.mostrarLivros();
                        }
                    }
                    else{
                        System.out.println(
                                "Você não tem nenhuma estante\n" +
                                "Deseja criar uma nova ? \n" +
                                "(1) Sim \n" +
                                "(2) Não \n");
                        var opcaoEstante = leitura.nextInt();
                        leitura.nextLine();
                        if(opcaoEstante == 1){
                            criarEstante();
                        }
                    }
                    break;
                case 4:
                    verEstantes();
                    break;
                case 5:
                    favoritos.mostrarLivros();
                    break;
                case 6:
                    livrosLidos.mostrarLivros();
                    break;
                case 7:
                    livrosSalvos.mostrarLivros();
                    break;
                case 8:
                    System.out.println("Até logo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

    private String obterLivroUsuario() {
        System.out.println("Digite o nome do livro");
        return leitura.nextLine();
    }
    private int exibirMenuPrincipal(){
        System.out.println("\nDigite a opção que deseja\n" +
                "(1) Buscar um livro\n" +
                "(2) Criar uma estante\n" +
                "(3) Buscar uma estante\n" +
                "(4) Ver todas as estantes\n" +
                "(5) Ver livros favoritos\n" +
                "(6) Ver livros já lidos\n"+
                "(7) Ver livros salvos\n" +
                "(8) Sair\n");
        var opcao = leitura.nextInt();
        leitura.nextLine();
        return opcao;
    }

    private int exibirMenuLivro(){
        System.out.println("\nDigite a opção que deseja\n" +
                "(1) Adicionar livro em uma estante\n" +
                "(2) Marcar como favorito\n" +
                "(3) Salvar livro\n" +
                "(4) Marcar como lido\n" +
                "(5) Voltar\n");
        var opcaoLivro = leitura.nextInt();
        leitura.nextLine();
        return opcaoLivro;
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

    private Livro selecionarLivro(List<DadosLivro> livros) {
        System.out.println("Selecione um livro para ver mais detalhes:");
        int opcao = leitura.nextInt();
        leitura.nextLine();
        if (opcao < 0 || opcao >= livros.size()) {
            System.out.println("Opção inválida!");
            return null;
        }
        Livro livroSelecionado = new Livro(livros.get(opcao).titulo(), livros.get(opcao).autores().get(0), livros.get(opcao).descricao());
        System.out.println(livroSelecionado);
        return livroSelecionado;
    }
    private void acaoLivroSelecionado(Livro livro){
        int opcaoLivro = -1;
        while (opcaoLivro!=5){
            opcaoLivro = exibirMenuLivro();
           switch (opcaoLivro){
                case 1:
                    verEstantes();
                    Estante estanteSelecionada;
                    if(!estantes.isEmpty()){
                        System.out.println("Digite o nome da estante");
                        String nome = leitura.nextLine();
                        estanteSelecionada = buscarEstante(nome);
                        if(estanteSelecionada != null){
                            estanteSelecionada.adicionarLivro(livro);
                        }
                    }
                    else{
                        System.out.println("Deseja criar uma nova ? \n" +
                                "(1) Sim \n" +
                                "(2) Não \n");
                        var opcao = leitura.nextInt();
                        leitura.nextLine();
                        if(opcao == 1){
                            criarEstante();
                        }
                    }
                    break;
                case 2:
                    mudarFavoritoLivro(livro);
                    break;
                case 3:
                   mudarSalvoLivro(livro);
                   break;
                case 4:
                    mudarLidoLivro(livro);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void criarEstante(){
        System.out.println("Digite o nome da estante");
        String nome = leitura.nextLine();
        System.out.println("Digite uma descricao para a estante");
        String descricao = leitura.nextLine();
        if(!nome.isEmpty() && !descricao.isEmpty()){
            Estante novaEstante = new Estante(nome, descricao);
            estantes.add(novaEstante);
            System.out.println("Estate " + novaEstante.getNome() + " criada com sucesso");
        }
        else{
            System.out.println("Todos os campos devem ser preenchidos");
        }
    }

    private void mudarFavoritoLivro(Livro livro){
        if(livro.ehFavorito()){
            livro.mudarFavorito();
            favoritos.removerLivro(livro);
            System.out.println("Livro desfavoritado");
        }
        else{
            livro.mudarFavorito();
            favoritos.adicionarLivro(livro);
            System.out.println("Livro favoritado com sucesso");
        }
    }

    private void mudarSalvoLivro(Livro livro){
        if(livro.estaSalvo()){
            livro.mudarSalvo();
            livrosSalvos.removerLivro(livro);
            System.out.println("Livro removido da estante de livros salvos");
        }
        else {
            livro.mudarSalvo();
            livrosSalvos.adicionarLivro(livro);
            System.out.println("Livro salvo com sucesso");
        }
    }

    private void mudarLidoLivro(Livro livro){
        if(livro.estaLido()){
            livro.mudarLido();
            livrosLidos.removerLivro(livro);
            System.out.println("Livro removido da estante de livros lidos");
        }
        else{
            livro.mudarSalvo();
            livrosLidos.adicionarLivro(livro);
            System.out.println("Livro marcado como lido");
        }
    }

    private Estante buscarEstante(String nomeEstante){
        for (Estante estante : estantes) {
            if (estante.getNome().equals(nomeEstante)) {
                return estante;
            }
            return null;
        }
        return null;
    }

    private void verEstantes(){
        if(estantes.isEmpty()){
            System.out.println("\nVocê não tem estantes\n");
        }
        else{
            estantes.forEach(System.out::println);
        }
    }
}

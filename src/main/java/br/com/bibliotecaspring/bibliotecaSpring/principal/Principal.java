package br.com.bibliotecaspring.bibliotecaSpring.principal;

import br.com.bibliotecaspring.bibliotecaSpring.models.*;
import br.com.bibliotecaspring.bibliotecaSpring.repository.LivroRepository;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConsumoAPI;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    private LivroRepository repository = new LivroRepository();

    public void executar() { //função principal
        var opcao = 0;
        while (opcao!=8){
            opcao = exibirMenuPrincipal(); //exibe as opções do menu de ações disponíveis para o usuário
            switch (opcao){
                case 1:
                    String livro = obterLivroUsuario(); // Pede o livro o nome do livro desejado pelo usuário
                    List<DadosLivro> livros = buscarLivros(livro); //Busca esse livro na API do google
                    exibirLivros(livros); //Exibe os 10 primeiros livros encontrados
                    Livro livroSelecionado = selecionarLivro(livros);
                    repository.saveAndFlush(livroSelecionado);// Pede para o usuário selecionar um livro
                    acaoLivroSelecionado(livroSelecionado); // Pede para o usuário escolher o que deseja fazer com o livro
                    break;
                case 2:
                    criarEstante(); //Cria uma estante nova
                    break;
                case 3:
                    if(!estantes.isEmpty()){ //Verifica se o usuário possui alguma estante criada
                        System.out.println("Digite o nome da estante");
                        String nomeEstante = leitura.nextLine();
                        Estante estanteBuscada = buscarEstante(nomeEstante); //Busca a estante que o usuário digitou
                        if(estanteBuscada != null){ // Caso encontre a estante retorna a impressão dessa estante e os livros que ela contem
                            System.out.println(estanteBuscada);
                            estanteBuscada.mostrarLivros();
                        }
                    }
                    else{ // Caso esteja vazia a lista de estantes, dá a opção de criar uma nova
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
                    verEstantes(); // Vê todas as estantes
                    break;
                case 5:
                    favoritos.mostrarLivros(); // mostra todos os livros favoritados
                    break;
                case 6:
                    livrosLidos.mostrarLivros(); // mostra todos os livros já lidos
                    break;
                case 7:
                    livrosSalvos.mostrarLivros(); // mostra todos os livros já salvos
                    break;
                case 8:
                    System.out.println("Até logo..."); //encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida"); // exibe mensagem de erro para o usuário caso ele não digite alguma das opções anteriores
                    break;
            }
        }

    }

    private String obterLivroUsuario() { // Função para retornar o que o livro que o usuário digitou
        System.out.println("Digite o nome do livro");
        return leitura.nextLine();
    }
    private int exibirMenuPrincipal(){ //Exibição das opções do menu principal,isto é, o primeiro menu que aparece
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

    private int exibirMenuLivro(){ //Exibição das opções do menu quando o usuário busca um livro
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

    private List<DadosLivro> buscarLivros(String livro) { //Busca os livros na API do google books
        String url = ENDERECO + livro.replace(" ", "+") + "&key=" + API_KEY;
        String json = consumo.obterDados(url);
        DadosBusca dadosBusca = conversor.obterDados(json, DadosBusca.class);
        return dadosBusca.items()
                .stream()
                .map(DadosItem::volumeInfo)
                .filter(l -> l.genero() != null)
                .collect(Collectors.toList());
    }

    private void exibirLivros(List<DadosLivro> livros) { //Exibi os livros recebidos de uma lista
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("[" + i + "] " + livros.get(i).titulo());
        }
    }

    private Livro selecionarLivro(List<DadosLivro> livros) { //Seleciona o livro desejado pelo usuário e retorna-o
        System.out.println("Selecione um livro para ver mais detalhes:");
        int opcao = leitura.nextInt();
        leitura.nextLine();
        if (opcao < 0 || opcao >= livros.size()) { //Verifica se é uma opção válida, isto é, não pode ser menor que 0 ou maior que o tamanho das opções
            System.out.println("Opção inválida!");
            return null;
        }
        var listaLivros = livros.get(opcao);
        Livro livroSelecionado = new Livro(listaLivros.titulo(), listaLivros.autores().get(0), listaLivros.genero().get(0), listaLivros.imagem().smallThumbnail(),listaLivros.descricao(), listaLivros.qtdPaginas());
        System.out.println(livroSelecionado);
        return livroSelecionado;
    }

    private Estante selecionarEstante(List<Estante> estantes) { //Selecionar estante, mas ainda está em construção...
        System.out.println("Selecione um livro para ver mais detalhes:");
        int opcao = leitura.nextInt();
        leitura.nextLine();
        if (opcao < 0 || opcao >= estantes.size()) {
            System.out.println("Opção inválida!");
            return null;
        }
        Estante estanteSelecionada = new Estante(estantes.get(opcao).getNome(), estantes.get(opcao).getDescricao());
        System.out.println(estanteSelecionada);
        return estanteSelecionada;
    }
    private void acaoLivroSelecionado(Livro livro){ // função para executar as ações presentes no menu que aparece quando o usuário buscar um livro
        int opcaoLivro = -1;
        while (opcaoLivro!=5){
            opcaoLivro = exibirMenuLivro(); //Exibição do menu de ações para o livro selecionado
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
    private Estante buscarEstante(String nomeEstante ){
        for (Estante estante : estantes) {
            if (estante.getNome().equals(nomeEstante)) {
                return estante;
            }
            return null;
        }
        return null;
    };

    private void verEstantes() {
        if (estantes.isEmpty()) {
            System.out.println("\nVocê não tem estantes\n");
        } else {
            estantes.forEach(System.out::println);
        }
    }

    private void mudarLidoLivro(Livro livro) {
        if (livro.estaLido()) {
            livro.mudarLido();
            livrosLidos.removerLivro(livro);
            System.out.println("Livro removido da estante de livros lidos");
        } else {
            livro.mudarSalvo();
            livrosLidos.adicionarLivro(livro);
            System.out.println("Livro marcado como lido");
        }
    }
    }

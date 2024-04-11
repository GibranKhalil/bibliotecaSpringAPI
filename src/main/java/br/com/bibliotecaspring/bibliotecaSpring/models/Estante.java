package br.com.bibliotecaspring.bibliotecaSpring.models;

import java.util.ArrayList;
import java.util.List;

public class Estante {
    private String nome;
    private String descricao;
    private final List<Livro> listaLivros;

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
        System.out.println("Livro: " + livro.getTitulo() + " adicionado na estante " + getNome());
    }

    public void removerLivro(Livro livro) {
        listaLivros.remove(livro);
        System.out.println("Livro: " + livro.getTitulo() + " removido da estante" + getNome());
        System.out.println("Quantidade de livros na lista: " + listaLivros.size());
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getListaLivros(){
        return listaLivros;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estante(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        listaLivros = new ArrayList<>();
    }

    public boolean estaVazia(){
        return listaLivros.isEmpty();
    }

    public void mostrarLivros(){
        if(listaLivros.isEmpty()){
            System.out.println("Estante vazia");
        }
        else{
            listaLivros.forEach(System.out::println);
            System.out.println("\n");
        }
    }

    @Override
    public String toString() {
        return "Estante{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +'}';
    }
}

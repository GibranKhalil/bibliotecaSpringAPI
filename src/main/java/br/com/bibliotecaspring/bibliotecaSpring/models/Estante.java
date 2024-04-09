package br.com.bibliotecaspring.bibliotecaSpring.models;

import java.util.ArrayList;
import java.util.List;

public class Estante {
    private String nome;
    private String descricao;
    private final List<Livro> listaLivros;

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
        System.out.println("Livro: " + livro.getTitulo() + " adicionado na lista");
    }

    public void removerLivro(Livro livro) {
        listaLivros.remove(livro);
        System.out.println("Livro: " + livro.getTitulo() + " removido da lista" );
        System.out.println("Quantidade de livros na lista: " + listaLivros.size());
    }

    public String getNome() {
        return nome;
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
        this.listaLivros = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Estante{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", listaLivros=" + listaLivros +
                '}';
    }
}

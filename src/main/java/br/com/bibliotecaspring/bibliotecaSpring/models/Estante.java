package br.com.bibliotecaspring.bibliotecaSpring.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estantes")
public class Estante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome; //nome da estante
    private String descricao; //descricao da estante
    @OneToMany(mappedBy = "estante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final List<Livro> listaLivros; //Lista para armazenar os livros

    public Estante(List<Livro> listaLivros) {

        this.listaLivros = listaLivros;
    }
    public void adicionarLivro(Livro livro) { //função para adicionar um livro
        listaLivros.add(livro);
        System.out.println("Livro: " + livro.getTitulo() + " adicionado na estante " + getNome());
    }

    public void removerLivro(Livro livro) { //remove um livro da lista
        listaLivros.remove(livro);
        System.out.println("Livro: " + livro.getTitulo() + " removido da estante " + getNome());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Livro> getListaLivros(){
        return listaLivros;
    }

    public Estante(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        listaLivros = new ArrayList<>();
    }

    public void mostrarLivros(){
        if(listaLivros.isEmpty()){
            System.out.println("Estante vazia");
        }
        else{
            listaLivros.forEach(System.out::println); //uso do foreach ao invés do for para facilitar legibilidade
            System.out.println("\n");
        }
    } //mostra todos os livros da estante

    @Override
    public String toString() {
        return "Estante{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +'}';
    }
}

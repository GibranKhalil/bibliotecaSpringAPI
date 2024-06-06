package br.com.bibliotecaspring.bibliotecaSpring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    private boolean estaLido;
    private boolean estaSalvo;
    private String titulo;
    private String autor;
    private String sobre;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private boolean ehFavorito;
    private String urlCapa;
    private String resumo;
    private Number qtdCapitulo;
    private Number qtdPagina;

    @ManyToOne
    private Estante estante;

    public Livro(String titulo, String autor, String sobre, Genero genero, String urlCapa, String resumo, Number qtdCapitulo, Number qtdPagina) {
        this.titulo = titulo;
        this.autor = autor;
        this.sobre = sobre;
        this.genero = genero;
        this.urlCapa = urlCapa;
        this.resumo = resumo;
        this.qtdCapitulo = qtdCapitulo;
        this.qtdPagina = qtdPagina;
        this.estaSalvo = false;
        this.estaLido = false;
        this.ehFavorito = false;
    }

    public Livro(String Titulo, String autor, String resumo){
        this.titulo = Titulo;
        this.autor = autor;
        this.resumo = resumo;
    }

    public Livro() {

    }


    public void mudarLido() {
        this.estaLido = !this.estaLido;
    }

    public void mudarSalvo() {
        this.estaSalvo = !this.estaSalvo;
    }

    public void mudarFavorito() {
        this.ehFavorito = !this.ehFavorito;
    }

    public boolean estaLido() {
        return estaLido;
    }
    public boolean estaSalvo() {
        return estaSalvo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getSobre() {
        return sobre;
    }
    public Genero getGenero() {
        return genero;
    }
    public boolean ehFavorito() {
        return ehFavorito;
    }
    public String getCapa() {
        return urlCapa;
    }
    public String getResumo() {
        return resumo;
    }
    public Number getQtdCapitulo() {
        return qtdCapitulo;
    }
    public Number getQtdPagina() {
        return qtdPagina;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + "\n"+
                "Autor: " + this.autor + "\n" +
                "Resumo: " + this.resumo;
    }
}

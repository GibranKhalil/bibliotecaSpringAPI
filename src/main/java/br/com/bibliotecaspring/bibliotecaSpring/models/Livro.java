package br.com.bibliotecaspring.bibliotecaSpring.models;

public class Livro {

    private int ID;
    private String titulo;
    private String autor;
    private String genero;
    private boolean ehFavorito;
    private String urlCapa;
    private String resumo;
    private int qtdPagina;

    public Livro(){

    }

    public Livro(int ID, String titulo, String autor, String genero, String urlCapa, String resumo, int qtdPagina) {
        this.titulo = titulo;
        this.ID = ID;
        this.autor = autor;
        this.genero = genero;
        this.urlCapa = urlCapa;
        this.resumo = resumo;
        this.qtdPagina = qtdPagina;
        this.ehFavorito = false;
    }

    public Livro(String Titulo, String autor, String resumo){
        this.titulo = Titulo;
        this.autor = autor;
        this.resumo = resumo;
    }

    public void mudarFavorito() {
        this.ehFavorito = !this.ehFavorito;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getGenero() {
        return genero;
    }
    public boolean ehFavorito() {
        return ehFavorito;
    }
    public String getResumo() {
        return resumo;
    }
    public Number getQtdPagina() {
        return qtdPagina;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.titulo + "\n"+
                "Autor: " + this.autor + "\n" +
                "Resumo: " + this.resumo;
    }
}

package br.com.bibliotecaspring.bibliotecaSpring.models;

import java.util.ArrayList;
import java.util.List;


public class Estante {
    private int ID;
    private String nome; //nome da estante
    private String descricao; //descricao da estante

    public Estante(String nome, String descricao, int ID){
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Estante{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +'}';
    }
}

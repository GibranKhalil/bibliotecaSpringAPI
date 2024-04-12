package br.com.bibliotecaspring.bibliotecaSpring.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //propriedade para ignorar os campos recebidos mas não especificados com @JsonAlias
public record DadosBusca(@JsonAlias("items") List<DadosItem> items ) {
    //Essa classe record, é utilizada para resgatar o array de objetos contido no json gerado pela busca do livro na API
    //@JsonAlias é uma função da biblioteca Jackson DataBind do maven e serve para resgatar um item com o nome passado['items']
    //como mudar seu nome para o atributo passado posteriormente [items].
}

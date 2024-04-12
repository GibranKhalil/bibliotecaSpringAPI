package br.com.bibliotecaspring.bibliotecaSpring.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //propriedade para ignorar os campos recebidos mas não especificados com @JsonAlias
public record DadosItem(@JsonAlias("volumeInfo") DadosLivro volumeInfo ) {
    //Essa classe record, é utilizada para resgatar o array de objetos contido no items gerado pela busca do livro na API
    // e resgatado pela classe record DadosBusca
    //@JsonAlias é uma função da biblioteca Jackson DataBind do maven e serve para resgatar um item com o nome passado['volumeInfo']
    //como mudar seu nome para o atributo passado posteriormente [volumeInfo].
}

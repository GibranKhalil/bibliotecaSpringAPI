package br.com.bibliotecaspring.bibliotecaSpring.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //propriedade para ignorar os campos recebidos mas não especificados com @JsonAlias
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("description") String descricao,
                         @JsonAlias("authors") List<String> autores,
                         @JsonAlias("language") String idioma,
                         @JsonAlias("pageCount") Integer qtdPaginas,
                         @JsonAlias("imageLinks") DadosImagem imagem,
                         @JsonAlias("infoLink") String infoLink,
                         @JsonAlias("previewLink") String previewLink,
                         @JsonAlias("categories") List<String> genero
                         ) {
    //Essa classe record, é utilizada para resgatar o os objetos contidos no volumeInfo gerado pela busca do livro na API
    // e resgatado pela classe record DadosItem
    //@JsonAlias é uma função da biblioteca Jackson DataBind do maven e serve para resgatar um item com o nome passado
    //como mudar seu nome para o atributo passado posteriormente .
}

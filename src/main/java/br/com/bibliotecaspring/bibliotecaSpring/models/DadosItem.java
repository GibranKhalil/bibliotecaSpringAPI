package br.com.bibliotecaspring.bibliotecaSpring.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosItem(@JsonAlias("volumeInfo") DadosLivro volumeInfo ) {
}

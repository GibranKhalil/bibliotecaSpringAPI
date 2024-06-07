package br.com.bibliotecaspring.bibliotecaSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosImagem(String smallThumbnail, String thumbnail ) {
}

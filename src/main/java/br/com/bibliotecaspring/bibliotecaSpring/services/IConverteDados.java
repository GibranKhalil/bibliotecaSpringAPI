package br.com.bibliotecaspring.bibliotecaSpring.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

package br.com.bibliotecaspring.bibliotecaSpring.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient(); //Cria um client para enviar requisições
        HttpRequest request = HttpRequest.newBuilder() //Lida com o pedido feito pelo usuário
                .uri(URI.create(endereco)) // Configura para que o pedido seja redirecionado para o endereço passado
                .build();
        HttpResponse<String> response = null; // Traz a resposta recebida
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString()); //envia a resposta para o cliente
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body(); // retorna em formato json normalmente
    }
}

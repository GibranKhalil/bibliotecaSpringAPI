package br.com.bibliotecaspring.bibliotecaSpring.controllers;

import br.com.bibliotecaspring.bibliotecaSpring.DTO.LivroDTO;
import br.com.bibliotecaspring.bibliotecaSpring.models.DadosBusca;
import br.com.bibliotecaspring.bibliotecaSpring.models.DadosItem;
import br.com.bibliotecaspring.bibliotecaSpring.models.DadosLivro;
import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConsumoAPI;
import br.com.bibliotecaspring.bibliotecaSpring.services.ConverteDados;
import br.com.bibliotecaspring.bibliotecaSpring.services.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LivroController {

    private LivroService service;
    private final String ENDERECO = "https://www.googleapis.com/books/v1/volumes?q="; //Endereço base da api
    private final String API_KEY = "AIzaSyAVfXqFmSp0yuY4hbRvqI9S3c8VHv1p71M"; //Chave de acesso da API;
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    @GetMapping("/searchbook")
    public List<DadosLivro> fazerBusca(@RequestParam(value = "book", defaultValue = "o+poder+do+habito") String bookName){
        String url = ENDERECO + bookName.replace(" ", "+") + "&key=" + API_KEY;
        String json = consumo.obterDados(url);
        DadosBusca dadosBusca = conversor.obterDados(json, DadosBusca.class);
        return dadosBusca.items().stream().map(DadosItem::volumeInfo).collect(Collectors.toList());
    }
}

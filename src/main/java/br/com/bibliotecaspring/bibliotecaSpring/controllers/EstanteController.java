package br.com.bibliotecaspring.bibliotecaSpring.controllers;

import br.com.bibliotecaspring.bibliotecaSpring.DTO.EstanteDTO;
import br.com.bibliotecaspring.bibliotecaSpring.repository.EstanteRepository;
import br.com.bibliotecaspring.bibliotecaSpring.services.EstanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstanteController {

    private EstanteService service;
    @GetMapping("/bookcase")
    public List<EstanteDTO> getAll() {
        return service.obterTodasAsEstante();
    }
}

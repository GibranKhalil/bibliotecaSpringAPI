package br.com.bibliotecaspring.bibliotecaSpring.services;

import br.com.bibliotecaspring.bibliotecaSpring.DTO.EstanteDTO;
import br.com.bibliotecaspring.bibliotecaSpring.repository.EstanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstanteService {
    private EstanteRepository repository;

    public List<EstanteDTO> obterTodasAsEstante(){
        return  repository.findAll()
                .stream()
                .map(e -> new EstanteDTO(e.getId(), e.getNome(), e.getDescricao()))
                .collect(Collectors.toList());
    }
}

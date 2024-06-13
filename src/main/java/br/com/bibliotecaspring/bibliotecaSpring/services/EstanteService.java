package br.com.bibliotecaspring.bibliotecaSpring.services;

import br.com.bibliotecaspring.bibliotecaSpring.AppConfig;
import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
import br.com.bibliotecaspring.bibliotecaSpring.repository.EstanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanteService {
    private AppConfig config = new AppConfig();
    private EstanteRepository repository = new EstanteRepository(config.jdbcTemplate());

    public List<Estante> getAll(){
        return repository.findAll();
    }

    public int postEstante(Estante estante){
       return repository.save(estante);
    }

    public int deleteEstante(int ID){
        return repository.delete(ID);
    }
}

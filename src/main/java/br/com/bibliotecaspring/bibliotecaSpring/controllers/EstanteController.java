package br.com.bibliotecaspring.bibliotecaSpring.controllers;

import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import br.com.bibliotecaspring.bibliotecaSpring.services.EstanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstanteController {

    private EstanteService service = new EstanteService();

    @GetMapping("/bookcase")
    public List<Estante> getAll(){
        return service.getAll();
    }

    @GetMapping("/bookcasebooks/{ID}")
    public List<Livro> getBooks(@PathVariable int ID){
        return service.getBooks(ID);
    }

    @PostMapping("/bookcase")
    public int postEstante(@RequestBody Estante estante){
        return service.postEstante(estante);
    }

    @DeleteMapping("/bookcase/{ID}")
    public int deleteEstante(@PathVariable int ID){
        return service.deleteEstante(ID);
    }

}

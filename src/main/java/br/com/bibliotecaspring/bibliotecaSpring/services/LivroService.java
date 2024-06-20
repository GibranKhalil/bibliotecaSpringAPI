package br.com.bibliotecaspring.bibliotecaSpring.services;

import br.com.bibliotecaspring.bibliotecaSpring.AppConfig;
import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import br.com.bibliotecaspring.bibliotecaSpring.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private AppConfig config = new AppConfig();

    private LivroRepository repository = new LivroRepository(config.jdbcTemplate());

    public List<Livro> getAll(){
        return repository.findAll();
    }

    public int addBookToBookCase(int bookID, int bookCaseID){
        return  repository.addToBookCase(bookID, bookCaseID);
    }

    public int postBook(Livro livro){
        return repository.save(livro);
    }
}

package br.com.bibliotecaspring.bibliotecaSpring.repository;

import br.com.bibliotecaspring.bibliotecaSpring.mappers.LivroMapper;
import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livro> findAll(){
        return jdbcTemplate.query("SELECT * FROM livros", new LivroMapper());
    }

    public int save(Livro livro){
        return jdbcTemplate.update("INSERT INTO livros(titulo, autor, genero, urlCapa, resumo, qtdPagina) VALUES (?, ?, ?, ?, ?, ?)",
                livro.getTitulo(), livro.getAutor(), livro.getGenero(), livro.getUrlCapa(), livro.getResumo(), livro.getQtdPagina());
    }
}

package br.com.bibliotecaspring.bibliotecaSpring.repository;

import br.com.bibliotecaspring.bibliotecaSpring.mappers.EstanteMapper;
import br.com.bibliotecaspring.bibliotecaSpring.mappers.LivroMapper;
import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstanteRepository {
    private final JdbcTemplate jdbcTemplate;

    public EstanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Estante> findAll(){
        return jdbcTemplate.query("SELECT * FROM estantes", new EstanteMapper());
    }

    public List<Livro> getBooks(int id){
        return jdbcTemplate.query("SELECT * FROM livros WHERE estante_id = ? ",
                new Object[]{id}, new LivroMapper());
    }

    public Estante findByName(String nome) {
        return jdbcTemplate.queryForObject("SELECT * FROM estantes WHERE nome = ?", new Object[]{nome}, new EstanteMapper());
    }

    public int save(Estante estante) {
        return jdbcTemplate.update("INSERT INTO estantes (nome, descricao) VALUES (?, ?)",
                estante.getNome(), estante.getDescricao());
    }

    public int delete(int idEstante){
        return jdbcTemplate.update("DELETE FROM estantes WHERE ID = ?",
                idEstante);
    }
}

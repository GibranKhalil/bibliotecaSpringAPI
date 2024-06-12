package br.com.bibliotecaspring.bibliotecaSpring.repository;

import br.com.bibliotecaspring.bibliotecaSpring.mappers.EstanteMapper;
import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
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

    public Estante findByName(String nome) {
        return jdbcTemplate.queryForObject("SELECT * FROM estantes WHERE nome = ?", new Object[]{nome}, new EstanteMapper());
    }

    public int save(Estante estante) {
        return jdbcTemplate.update("INSERT INTO estantes (nome, descricao) VALUES (?, ?)",
                estante.getNome(), estante.getDescricao());
    }
}

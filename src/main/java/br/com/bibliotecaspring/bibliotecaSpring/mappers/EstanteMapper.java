package br.com.bibliotecaspring.bibliotecaSpring.mappers;

import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstanteMapper implements RowMapper<Estante> {
    @Override
    public Estante mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Estante(rs.getString("nome"), rs.getString("descricao"));
    }
}

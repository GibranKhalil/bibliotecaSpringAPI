package br.com.bibliotecaspring.bibliotecaSpring.mappers;

import br.com.bibliotecaspring.bibliotecaSpring.models.Livro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroMapper implements RowMapper<Livro> {
    @Override
    public Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Livro(rs.getInt("ID"), rs.getString("titulo"), rs.getString("autor"), rs.getString("genero"), rs.getString("urlCapa"), rs.getString("resumo"), rs.getInt("qtdPagina"));
    }
}

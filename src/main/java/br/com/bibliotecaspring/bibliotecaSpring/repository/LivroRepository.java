package br.com.bibliotecaspring.bibliotecaSpring.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

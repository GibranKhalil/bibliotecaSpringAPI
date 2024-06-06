package br.com.bibliotecaspring.bibliotecaSpring.repository;

import br.com.bibliotecaspring.bibliotecaSpring.models.Estante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EstanteRepository implements JpaRepository<Estante, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends Estante> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Estante> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Estante> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Estante getOne(Long aLong) {
        return null;
    }

    @Override
    public Estante getById(Long aLong) {
        return null;
    }

    @Override
    public Estante getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Estante> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Estante> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Estante> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Estante> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Estante> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Estante> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Estante, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Estante> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Estante> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Estante> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Estante> findAll() {
        return null;
    }

    @Override
    public List<Estante> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Estante entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Estante> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Estante> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Estante> findAll(Pageable pageable) {
        return null;
    }
}

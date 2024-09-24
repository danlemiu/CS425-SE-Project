package edu.miu.cs.cs425.finalproject.carmanagement.service;

import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    private final R repository;

    protected BaseService(R repository) {
        this.repository = repository;
    }

    public T create(@Valid T entity) {
        return repository.save(entity);
    }

    public T readOne(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> readAll() {
        return repository.findAll();
    }

    public T update(@Valid T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}

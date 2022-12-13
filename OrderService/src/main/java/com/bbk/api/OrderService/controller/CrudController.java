package com.bbk.api.OrderService.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CrudController<Entity, ID> {

    private final JpaRepository<Entity, ID> repository;

    CrudController(JpaRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Entity>> index() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> view(@PathVariable ID id) {
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Entity> update(@PathVariable ID id, @RequestBody Entity updateRequest) {
        Entity entity = repository.findById(id).get();
        BeanUtils.copyProperties(updateRequest, entity, "id");

        return new ResponseEntity<>(repository.save(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ID> destroy(@PathVariable ID id) {
        repository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

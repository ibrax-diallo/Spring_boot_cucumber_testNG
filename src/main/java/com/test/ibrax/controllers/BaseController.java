package com.test.ibrax.controllers;

import com.test.ibrax.documents.BaseEntity;
import com.test.ibrax.dto.response.DefaultResponse;
import com.test.ibrax.services.IBaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public abstract class BaseController<T extends BaseEntity, S extends IBaseService<T, ID>, ID> {

    public final S service;

    public BaseController(final S service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> findPage(Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable() final ID id) {
        if (id == null) {
            return new ResponseEntity<>(new DefaultResponse("Impossible de récupérer un objet avec un ID nul"), HttpStatus.BAD_REQUEST);
        }
        T object = service.find(id);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(object, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") ID id) {
        if (id == null) {
            return new ResponseEntity<>(new DefaultResponse("Impossible de récupérer un objet avec un ID nul"), HttpStatus.BAD_REQUEST);
        }
        String object = service.delete(id);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(new DefaultResponse(object), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") ID id, @RequestBody T entity) {
        if (id == null || entity == null) {
            return new ResponseEntity<>(new DefaultResponse("Impossible de récupérer un objet avec un ID nul"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
    }


}

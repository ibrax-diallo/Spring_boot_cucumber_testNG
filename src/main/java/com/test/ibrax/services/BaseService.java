package com.test.ibrax.services;

import com.test.ibrax.documents.BaseEntity;
import com.test.ibrax.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static com.test.ibrax.helpers.DateHelper.getTimestamp;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public class BaseService<T extends BaseEntity, R extends BaseRepository<T, ID>, ID> implements IBaseService<T, ID> {

    protected R repository;

    BaseService(final R repository) {
        this.repository = repository;
    }


    @Override
    public T create(final T object) {
        object.setCreatedAt(getTimestamp());
        return repository.save(object);
    }

    @Override
    public T find(final ID id) {
        return repository.findById((ID) id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll(Sort.by("createdAt").descending());
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T update(final ID id, final T object) {
        object.setId((String) id);
        T saved = repository.findById(id).orElse(null);
        if (saved == null) {
            object.setCreatedAt(getTimestamp());
        } else {
            object.setCreatedAt(saved.getCreatedAt());
            object.setUpdatedAt(getTimestamp());
        }
        repository.save(object);
        return object;
    }

    @Override
    public String delete(ID id) {
        T object = repository.findById(id).orElse(null);
        if (object == null) {
            return null;
        }
        repository.delete(object);
        return "A été effectuée avec succès";
    }


}

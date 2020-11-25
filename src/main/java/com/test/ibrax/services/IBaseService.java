package com.test.ibrax.services;
import com.test.ibrax.documents.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public interface IBaseService<T extends BaseEntity, ID> {

    T create(T object);

    T find(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    T update(ID id, T object);

    String delete ( ID id);



}

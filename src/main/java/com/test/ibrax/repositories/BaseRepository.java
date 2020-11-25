package com.test.ibrax.repositories;

import com.test.ibrax.documents.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public interface BaseRepository<T extends BaseEntity, ID> extends MongoRepository<T, ID> {
}

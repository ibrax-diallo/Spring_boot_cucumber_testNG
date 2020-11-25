package com.test.ibrax.repositories;

import com.test.ibrax.documents.Subscriber;
import org.springframework.stereotype.Repository;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Repository
public interface SubscriberRepository extends BaseRepository<Subscriber, String>{
    Subscriber findByAddress(String address);
}

package com.test.ibrax.services;

import com.test.ibrax.documents.Subscriber;
import com.test.ibrax.repositories.SubscriberRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class SubscriberService extends BaseService<Subscriber, SubscriberRepository,String> implements ISubscriber {
    SubscriberService(SubscriberRepository repository) {
        super(repository);
    }
}

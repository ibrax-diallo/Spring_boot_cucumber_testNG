package com.test.ibrax.controllers;

import com.test.ibrax.documents.Subscriber;
import com.test.ibrax.services.ISubscriber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@RestController
@RequestMapping("/api/v1/subscribers")
public class SubscriberController extends BaseController<Subscriber, ISubscriber, String> {
    public SubscriberController(ISubscriber service) {
        super(service);
    }
}

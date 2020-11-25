package com.test.ibrax.documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

@Data
@Document(collection = "subscribers")
public class Subscriber extends BaseEntity {

    private String address;

    private String status;

    public Subscriber(String address, String status) {

        this.address = address;

        this.status = status;

    }

}

package com.test.ibrax.documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

@Data
@Document(collection = "subscribers")
public class Subscriber extends BaseEntity {

    private String phone;

    private String zipCode;

    private String city;

    private String street;

    private String status;

    public Subscriber(String phone, String zipCode, String city, String street, String status) {
        this.phone = phone;

        this.zipCode = zipCode;

        this.city = city;

        this.street = street;

        this.status = status;

    }

}

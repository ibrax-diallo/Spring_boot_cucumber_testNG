package com.test.ibrax.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
@Document(collection = "users")
public class User extends BaseEntity {

    private String username;

    private String password;

   public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

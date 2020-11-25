package com.test.ibrax.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8571261118900116242L;

    @Id
    private String id;

    protected Long createdAt;

    private Long updatedAt;

    @JsonIgnore
    protected Boolean deleted = false;

    public BaseEntity() {
    }


}

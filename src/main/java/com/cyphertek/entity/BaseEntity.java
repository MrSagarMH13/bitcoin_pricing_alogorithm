package com.cyphertek.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @PrePersist
    public void prePersist() {
        if (createdOn == null)
            createdOn = (new Date()).toInstant();
        if (modifiedOn == null)
            createdOn = (new Date()).toInstant();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedOn = (new Date()).toInstant();
    }

    @Id
    @Column(name = "uuid", columnDefinition = "binary(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String uuid;

    @Column(name = "created_on", columnDefinition = "timestamp")
    private Instant createdOn;

    @Column(name = "created_by", columnDefinition = "varchar(100)")
    private String createdBy;

    @Column(name = "modified_on", columnDefinition = "timestamp")
    private Instant modifiedOn;

    @Column(name = "modified_by", columnDefinition = "varchar(100)")
    private String modifiedBy;
}

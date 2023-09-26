package com.jamli.gestiondestoks.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @CreatedDate
    @Column(name = "creationDate", nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;
//    @PrePersist
//    void prePersist() {
//        creationDate = Instant.now();
//    }
//    @PreUpdate
//    void preupdate() {
//        LastModifiedDate=Instant.now();
//        }
    }


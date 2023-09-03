package com.jamli.gestiondestoks.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;




@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

   // @CreatedDate
    @Column(name="creationDate")
   //j'ai pas besoin de ces attribue la
    private Instant creationDate;


    @Column(name="lastModifiedDate" )
    //@LastModifiedBy
    private Instant LastModifiedDate;
    @PrePersist
    void prePersist() {
        creationDate = Instant.now();
    }
    @PreUpdate
    void preupdate() {
        LastModifiedDate=Instant.now();
        }
    }


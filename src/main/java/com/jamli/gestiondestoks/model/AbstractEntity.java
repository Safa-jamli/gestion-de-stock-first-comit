package com.jamli.gestiondestoks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;




@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id ;

    @CreatedDate
    @Column(name="creationDate" ,nullable=false)
    @JsonIgnore //j'ai pas besoin de ces attribue la
    private Instant creationDate;


    @Column(name="lastUpdateDate" )
    @LastModifiedBy
    @JsonIgnore
    private Instant lastUpdateDate;
}

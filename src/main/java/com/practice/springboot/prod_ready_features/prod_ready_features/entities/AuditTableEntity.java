package com.practice.springboot.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
public class AuditTableEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private  LocalDateTime updatedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;
}

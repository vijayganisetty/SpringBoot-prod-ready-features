package com.practice.springboot.prod_ready_features.prod_ready_features.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class PostEntity extends AuditTableEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

}

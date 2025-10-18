package com.practice.springboot.prod_ready_features.prod_ready_features.controllers;


import com.practice.springboot.prod_ready_features.prod_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class auditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/posts/{id}")
    public List<PostEntity> getAllPostsRevisions(@PathVariable Long id){
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = auditReader.getRevisions(PostEntity.class, id);

        return revisions
                .stream()
                .map(revisionNumber -> auditReader.find(PostEntity.class, id, revisionNumber))
                .collect(Collectors.toList());
    }


}

package com.practice.springboot.prod_ready_features.prod_ready_features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class AuditorAwareImplemantation implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // get security context
        // get  authentication
        // get the principle
        // get the username
        return Optional.of("Vijay");
    }
}

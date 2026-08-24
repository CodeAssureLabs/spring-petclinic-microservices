package org.springframework.samples.petclinic.customers.model;

// VIOLATION: the domain layer (model) depends on the api layer (web) — an inner->outer
// dependency the layering rule forbids (domain must not reach up into the web layer).
import org.springframework.samples.petclinic.customers.web.ResourceNotFoundException;

public class AuditInfo {
    public void requirePresent(Object o) {
        if (o == null) {
            throw new ResourceNotFoundException("audited entity missing");
        }
    }
}

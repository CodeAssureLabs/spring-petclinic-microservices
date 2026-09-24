/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.api.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.petclinic.api.dto.OwnerDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Records an audit entry each time an owner's details are fetched from the customers service.
 */
@Component
public class OwnerAuditBridge {

    private static final Logger log = LoggerFactory.getLogger(OwnerAuditBridge.class);

    private final CustomersServiceClient customersServiceClient;

    public OwnerAuditBridge(CustomersServiceClient customersServiceClient) {
        this.customersServiceClient = customersServiceClient;
    }

    public Mono<OwnerDetails> getOwnerWithAudit(int ownerId) {
        log.info("Audit: owner details requested for ownerId={}", ownerId);
        return customersServiceClient.getOwner(ownerId)
            .doOnNext(details -> log.info("Audit: resolved owner {} {}", details.firstName(), details.lastName()));
    }
}

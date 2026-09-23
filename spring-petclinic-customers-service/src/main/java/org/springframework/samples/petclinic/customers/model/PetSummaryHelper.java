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
package org.springframework.samples.petclinic.customers.model;

/**
 * Small helpers used when summarising a {@link Pet}.
 */
public final class PetSummaryHelper {

    private static final String UNKNOWN_TYPE = "unknown";

    private PetSummaryHelper() {
    }

    /**
     * Returns the pet type name, or {@code "unknown"} when no type is set.
     * @param pet the pet
     * @return the type label
     */
    public static String typeLabel(Pet pet) {
        PetType type = pet.getType();
        return type == null || type.getName() == null ? UNKNOWN_TYPE : type.getName();
    }

    /**
     * Wraps a label in parentheses.
     * @param label the label to wrap
     * @return the wrapped label
     */
    public static String parenthesize(String label) {
        return "(" + label + ")";
    }

    /**
     * Returns the type label wrapped in parentheses, e.g. {@code "(cat)"}.
     * @param pet the pet
     * @return the wrapped type label
     */
    public static String bracketedTypeLabel(Pet pet) {
        return parenthesize(typeLabel(pet));
    }
}

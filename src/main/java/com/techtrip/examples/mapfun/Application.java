package com.techtrip.examples.mapfun;

import com.google.common.collect.ImmutableSet;
import com.techtrip.examples.mapfun.model.DisplayMappingSet;
import com.techtrip.examples.mapfun.model.EventType;

import java.util.Set;

public class Application {

    static final Set<EventType> APPROVED = ImmutableSet.of(EventType.INSTRUCTION_APPROVED, EventType.ANOTHER_INSTRUCTION_APPROVED);
    static final Set<EventType> PENDING  = ImmutableSet.of(EventType.INSTRUCTION_PENDING, EventType.ANOTHER_INSTRUCTION_PENDING);
    static final Set<EventType> INVALID  = ImmutableSet.of(EventType.INSTRUCTION_APPROVED, EventType.INSTRUCTION_PENDING);

    public static void main(String args[]) {

        System.out.println("APPROVED EVENT: " + DisplayMappingSet.lookupDisplayString(APPROVED));
        System.out.println("PENDING EVENT: " + DisplayMappingSet.lookupDisplayString(PENDING));
        System.out.println("INVALID EVENT: " + DisplayMappingSet.lookupDisplayString(INVALID));
    }
}



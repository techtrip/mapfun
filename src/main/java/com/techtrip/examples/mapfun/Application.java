package com.techtrip.examples.mapfun;

import com.google.common.collect.ImmutableSet;
import com.techtrip.examples.mapfun.model.DisplayMappingSet;
import com.techtrip.examples.mapfun.model.EventType;

import java.util.Map;
import java.util.Set;

public class Application {

    /**
     *     APPROVED(ImmutableSet.of(EventType.INSTRUCTION_APPROVED, EventType.ANOTHER_INSTRUCTION_APPROVED), "APPROVED"),
     *     PENDING(ImmutableSet.of(EventType.INSTRUCTION_PENDING, EventType.ANOTHER_INSTRUCTION_PENDING), "APPROVED");
     * @param args
     */

    static final Set<EventType> APPROVED = ImmutableSet.of(EventType.INSTRUCTION_APPROVED, EventType.ANOTHER_INSTRUCTION_APPROVED);
    static final Set<EventType> PENDING  = ImmutableSet.of(EventType.INSTRUCTION_PENDING, EventType.ANOTHER_INSTRUCTION_PENDING);
    public static void main(String args[]) {

        System.out.println("Approved String: " + DisplayMappingSet.lookupDisplayString(APPROVED));
        System.out.println("PENDING String: " + DisplayMappingSet.lookupDisplayString(PENDING));
    }


}



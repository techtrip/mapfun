package com.techtrip.examples.mapfun.model;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

public enum DisplayMappingSet {
    APPROVED(ImmutableSet.of(EventType.INSTRUCTION_APPROVED, EventType.ANOTHER_INSTRUCTION_APPROVED), "APPROVED"),
    PENDING(ImmutableSet.of(EventType.INSTRUCTION_PENDING, EventType.ANOTHER_INSTRUCTION_PENDING), "PENDING");

    private final Set<EventType> eventMappings;
    private final String displayString;

    DisplayMappingSet(Set<EventType> eventMappings, String displayString) {
        this.eventMappings = eventMappings;
        this.displayString = displayString;
    }

    public static String lookupDisplayString(Set<EventType> eventMappingsCompare) {

        for (DisplayMappingSet displayMappingSet: DisplayMappingSet.values()){
            if ((displayMappingSet.eventMappings.size() == eventMappingsCompare.size()) && (displayMappingSet.eventMappings.containsAll(eventMappingsCompare))) {
                return displayMappingSet.displayString;
            }
        }

        return "EVENT_MAPPING_NOT_FOUND";
    }
}

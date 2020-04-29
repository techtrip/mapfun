# MapFun

This simple utility classes takes maps a set of Enums to a string. Usefule for Display Options

Basically you may need to map sets of values to open strings. The sets may overlap somewhat so I just demonstrate equality but
we can use Guava `SETS` to create cartesian products.

See `DisplayMappingSet.java` nad `EventType.java`

Given:
```java
public enum EventType {
    INSTRUCTION_APPROVED,
    ANOTHER_INSTRUCTION_APPROVED,
    INSTRUCTION_PENDING,
    ANOTHER_INSTRUCTION_PENDING
}
```
***AND

```java
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

```

Simple Runtime Test:
```java
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
```

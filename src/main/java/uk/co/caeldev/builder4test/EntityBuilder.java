package uk.co.caeldev.builder4test;

import java.util.function.Supplier;

public class EntityBuilder<K> {

    private final FieldLookup fieldLookup;
    private final Creator<K> creator;

    EntityBuilder(Creator<K> creator) {
        this.creator = creator;
        this.fieldLookup = new FieldLookup();
    }

    static <T> EntityBuilder entityBuilder(Creator<T> Creator) {
        return new EntityBuilder<>(Creator);
    }

    public EntityBuilder with(Supplier<Value> value) {
        fieldLookup.add(value.get());
        return this;
    }

    public K get() {
        creator.initializeLookup(fieldLookup);
        return creator.create();
    }
}

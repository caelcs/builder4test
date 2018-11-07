package uk.co.caeldev.builder4test;

class EntityBuilder<K> {

    private final FieldLookup fieldLookup;
    private final Creator<K> creator;

    EntityBuilder(Creator<K> creator) {
        this.creator = creator;
        this.fieldLookup = new FieldLookup();
    }

    static <T> EntityBuilder<T> entityBuilder(Creator<T> Creator) {
        return new EntityBuilder<>(Creator);
    }

    <V> EntityBuilder<K> with(String fieldName, V value) {
        fieldLookup.add(new Value<>(fieldName, value));
        return this;
    }

    K get() {
        creator.initializeLookup(fieldLookup);
        return creator.create();
    }
}

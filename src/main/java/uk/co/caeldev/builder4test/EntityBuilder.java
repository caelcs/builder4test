package uk.co.caeldev.builder4test;

class EntityBuilder<K> {

    private final Lookup lookup;
    private final Creator<K> creator;

    EntityBuilder(Creator<K> creator) {
        this.creator = creator;
        this.lookup = new Lookup();
    }

    static <T> EntityBuilder<T> entityBuilder(Creator<T> Creator) {
        return new EntityBuilder<>(Creator);
    }

    <V> EntityBuilder<K> with(String fieldName, V value) {
        lookup.add(new Value<>(fieldName, value));
        return this;
    }

    K get() {
        creator.initializeLookup(lookup);
        return creator.create();
    }
}

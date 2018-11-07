package uk.co.caeldev.builder4test;

public abstract class Creator<T> {

    Lookup lookup;

    public abstract T build();

    void initializeLookup(Lookup lookup) {
        this.lookup = lookup;
    }

    public <K> K lookup(String fieldName, K defaultValue) {
        return lookup.get(fieldName, defaultValue);
    }

}

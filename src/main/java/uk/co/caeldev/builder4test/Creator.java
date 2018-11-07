package uk.co.caeldev.builder4test;

public abstract class Creator<T> {

    protected FieldLookup fieldLookup;

    public abstract T builder(FieldLookup fieldLookup);

    public void initializeLookup(FieldLookup fieldLookup) {
        this.fieldLookup = fieldLookup;
    }

    public T create() {
        return builder(fieldLookup);
    }

}

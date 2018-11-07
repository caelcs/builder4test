package uk.co.caeldev.builder4test;

public abstract class Creator<T> {

    protected Lookup lookup;

    public abstract T builder(Lookup lookup);

    public void initializeLookup(Lookup lookup) {
        this.lookup = lookup;
    }

    public T create() {
        return builder(lookup);
    }

}

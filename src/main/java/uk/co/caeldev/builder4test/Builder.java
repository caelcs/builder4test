package uk.co.caeldev.builder4test;

public class Builder {

    Builder() {
    }

    public static Builder build() {
        return new Builder();
    }

    public EntityBuilder entity(Creator creator) {
        return EntityBuilder.entityBuilder(creator);
    }
}

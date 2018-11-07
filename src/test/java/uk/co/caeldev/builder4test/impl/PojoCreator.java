package uk.co.caeldev.builder4test.impl;

import uk.co.caeldev.builder4test.Creator;

public class PojoCreator extends Creator<Pojo> {

    @Override
    public Pojo build() {
        return new Pojo(lookup("name", "defaultName"),
                lookup("value", "defaultValue"));
    }

}

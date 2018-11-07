package uk.co.caeldev.builder4test.impl;

import uk.co.caeldev.builder4test.Creator;
import uk.co.caeldev.builder4test.Lookup;

public class PojoCreator extends Creator<Pojo> {

    @Override
    public Pojo builder(Lookup lookup) {
        return new Pojo(lookup.get("name", "defaultName"),
                    lookup.get("value", "defaultValue"));
    }

}

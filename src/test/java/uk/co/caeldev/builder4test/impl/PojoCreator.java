package uk.co.caeldev.builder4test.impl;

import uk.co.caeldev.builder4test.Creator;
import uk.co.caeldev.builder4test.FieldLookup;

import static uk.org.fyodor.generators.RDG.string;

public class PojoCreator extends Creator<Pojo> {

    @Override
    public Pojo builder(FieldLookup fieldLookup) {
        return new Pojo(fieldLookup.lookup("name", string().next()),
                    fieldLookup.lookup("value", string().next()));
    }

}

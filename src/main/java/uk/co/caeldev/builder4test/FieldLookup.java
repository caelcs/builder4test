package uk.co.caeldev.builder4test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class FieldLookup {

    Map<String, Value> fields;

    public FieldLookup() {
        this.fields = new HashMap<>();
    }

    public void add(Value field) {
        fields.put(field.fieldId, field);
    }

    public void addAll(Map<String, Value> fields) {
        fields.putAll(fields);
    }

    public <K> K lookup(String fieldName, K defaultValue) {
        Object value = fields.get(fieldName).getValue();
        return isNull(value)? defaultValue : (K) value;
    }
}

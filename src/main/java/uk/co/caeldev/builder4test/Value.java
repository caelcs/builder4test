package uk.co.caeldev.builder4test;

public class Value<T> {

    String fieldId;
    T value;

    public Value(String fieldId, T value) {
        this.fieldId = fieldId;
        this.value = value;
    }

    public String getFieldId() {
        return fieldId;
    }

    public T getValue() {
        return value;
    }
}

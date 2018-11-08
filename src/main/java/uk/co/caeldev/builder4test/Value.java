package uk.co.caeldev.builder4test;

class Value<T> {

    String fieldId;
    T value;

    Value(String fieldId, T value) {
        this.fieldId = fieldId;
        this.value = value;
    }

    T getValue() {
        return value;
    }
}

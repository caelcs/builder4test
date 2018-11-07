package uk.co.caeldev.builder4test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldLookupTest {

    private FieldLookup fieldLookup;

    @BeforeEach
    public void createLookup() {
        fieldLookup = new FieldLookup();
    }

    @Test
    public void fieldsShouldNotBeNull() {
        assertThat(fieldLookup.fields).isNotNull();
    }

    @Test
    public void shouldAddNewValue() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //When
        fieldLookup.add(value);

        //Then
        assertThat(fieldLookup.fields)
                .containsKey("name")
                .containsValue(value);
    }

    @Test
    public void shouldLookupExistingValue() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //And
        fieldLookup.add(value);

        //When
        String lookup = fieldLookup.lookup("name", "test");

        //Then
        assertThat(lookup)
                .isEqualTo("default");
    }

    @Test
    public void shouldLookupExistingFieldNameWithNullValue() {
        //Given
        Value<String> value = new Value<>("name", null);

        //And
        fieldLookup.add(value);

        //When
        String lookup = fieldLookup.lookup("name", "test");

        //Then
        assertThat(lookup).isEqualTo("test");
    }

    @Test
    public void shouldReturnDefaultWhenFieldNameDoesNotExists() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //And
        fieldLookup.add(value);

        //When
        String lookup = fieldLookup.lookup("file", "test");

        //Then
        assertThat(lookup).isEqualTo("test");
    }

}
package uk.co.caeldev.builder4test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LookupTest {

    private Lookup lookup;

    @BeforeEach
    public void createLookup() {
        lookup = new Lookup();
    }

    @Test
    public void fieldsShouldNotBeNull() {
        assertThat(lookup.fields).isNotNull();
    }

    @Test
    public void shouldAddNewValue() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //When
        lookup.add(value);

        //Then
        assertThat(lookup.fields)
                .containsKey("name")
                .containsValue(value);
    }

    @Test
    public void shouldLookupExistingValue() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //And
        lookup.add(value);

        //When
        String lookup = this.lookup.get("name", "test");

        //Then
        assertThat(lookup)
                .isEqualTo("default");
    }

    @Test
    public void shouldLookupExistingFieldNameWithNullValue() {
        //Given
        Value<String> value = new Value<>("name", null);

        //And
        lookup.add(value);

        //When
        String lookup = this.lookup.get("name", "test");

        //Then
        assertThat(lookup).isEqualTo("test");
    }

    @Test
    public void shouldReturnDefaultWhenFieldNameDoesNotExists() {
        //Given
        Value<String> value = new Value<>("name", "default");

        //And
        lookup.add(value);

        //When
        String lookup = this.lookup.get("file", "test");

        //Then
        assertThat(lookup).isEqualTo("test");
    }

}
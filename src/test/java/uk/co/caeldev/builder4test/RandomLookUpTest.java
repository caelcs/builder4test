package uk.co.caeldev.builder4test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.org.fyodor.generators.RDG.string;

class RandomLookUpTest {


    @Test
    @DisplayName("Should get different random values for each field")
    public void shouldLookupARandomValue() {
        //Given
        Field<String> field = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(Maps.newHashMap(), ImmutableMap.of(field, string()));

        //When
        String result1 = lookUp.get(field);
        String result2 = lookUp.get(field);


        //Then
        assertThat(result1).isNotBlank();
        assertThat(result2).isNotBlank();
        assertThat(result1).isNotEqualTo(result2);
    }

    @Test
    @DisplayName("Should get random and constant values")
    public void shouldLookupARandomValueAndConstantValue() {
        //Given
        Field<String> field1 = new Field<>();
        Field<String> field2 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(ImmutableMap.of(field1, Optional.of("test")),
                ImmutableMap.of(field2, string()));

        //When
        String result1 = lookUp.get(field1);
        String result2 = lookUp.get(field2);


        //Then
        assertThat(result1).isNotBlank();
        assertThat(result2).isNotBlank();
        assertThat(result1).isEqualTo("test");
        assertThat(result2).isNotEqualTo(result1);
    }

    @Test
    @DisplayName("Should retrieve the constant value when there is a random value has well")
    public void shouldLookupConstantValueOverridesRandomValueForDoubleDefinition() {
        //Given
        Field<String> field1 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(ImmutableMap.of(field1, Optional.of("test")),
                ImmutableMap.of(field1, string()));

        //When
        String result1 = lookUp.get(field1);

        //Then
        assertThat(result1).isNotBlank();
        assertThat(result1).isEqualTo("test");
    }

    @Test
    @DisplayName("Should retrieve the default value when there is no definition for that field")
    public void shouldLookupForDefaultValueWhenThereIsNoValue() {
        //Given
        Field<String> field1 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(Maps.newHashMap(), Maps.newHashMap());

        //When
        String result1 = lookUp.get(field1, "test");

        //Then
        assertThat(result1).isEqualTo("test");
    }

    @Test
    @DisplayName("Should retrieve null when there is a null entry for a field")
    public void shouldLookupForNullWhenThereIsNullValueSet() {
        //Given
        Field<String> field1 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(ImmutableMap.of(field1, Optional.empty()), Maps.newHashMap());

        //When
        String result1 = lookUp.get(field1, "test");

        //Then
        assertThat(result1).isNull();
    }

    @Test
    @DisplayName("Should retrieve empty when the value is empty for a field")
    public void shouldLookupForEmptyWhenThereIsEmptyValueSet() {
        //Given
        Field<String> field1 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(ImmutableMap.of(field1, Optional.of("")), Maps.newHashMap());

        //When
        String result1 = lookUp.get(field1, "test");

        //Then
        assertThat(result1).isEmpty();
    }

    @Test
    @DisplayName("Should retrieve the value set by using put method for a field")
    public void shouldLookupForValueInsertedByUsingPut() {
        //Given
        Field<String> field1 = new Field<>();
        RandomLookUp lookUp = new RandomLookUp(Maps.newHashMap(), Maps.newHashMap());

        //And
        lookUp.put(field1, "");

        //When
        String result1 = lookUp.get(field1, "test");

        //Then
        assertThat(result1).isEmpty();
    }
}
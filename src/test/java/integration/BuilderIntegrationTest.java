package integration;

import org.junit.jupiter.api.Test;
import uk.co.caeldev.builder4test.Builder;
import uk.co.caeldev.builder4test.Creator;
import uk.co.caeldev.builder4test.impl.Pojo;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderIntegrationTest {

    @Test
    public void shouldBuildPojo() {
        //When
        Pojo pojo = Builder.build().entity(getCreator()).get();

        //Then
        assertThat(pojo.getName()).isEqualTo("Testname");
        assertThat(pojo.getValue()).isEqualTo("TestValue");
    }

    @Test
    public void shouldBuildPojoOverridingValues() {
        //When
        Pojo pojo = Builder.build()
                .entity(getCreator())
                .with("name", "nameoverrideed")
                .with("value", "valueoverrided")
                .get();

        //Then
        assertThat(pojo.getName()).isEqualTo("nameoverrideed");
        assertThat(pojo.getValue()).isEqualTo("valueoverrided");
    }

    private Creator<Pojo> getCreator() {
        return new Creator<Pojo>() {
            @Override
            public Pojo build() {
                return new Pojo(lookup("name", "Testname"), lookup("value", "TestValue"));
            }
        };
    }
}

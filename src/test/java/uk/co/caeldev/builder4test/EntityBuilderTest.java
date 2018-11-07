package uk.co.caeldev.builder4test;

import org.junit.jupiter.api.Test;
import uk.co.caeldev.builder4test.impl.Pojo;
import uk.co.caeldev.builder4test.impl.PojoCreator;

import static org.assertj.core.api.Assertions.assertThat;

class EntityBuilderTest {

    @Test
    public void shouldBuild() {
        EntityBuilder entityBuilder = EntityBuilder.entityBuilder(new PojoCreator());
        EntityBuilder entityBuilder2 = EntityBuilder.entityBuilder(new PojoCreator());

        assertThat(entityBuilder).isNotEqualTo(entityBuilder2);
    }

    @Test
    public void shouldGetEntityUsingDefaultValues() {
        Pojo pojo = EntityBuilder.entityBuilder(new PojoCreator()).get();

        assertThat(pojo.getName()).isEqualTo("defaultName");
        assertThat(pojo.getValue()).isEqualTo("defaultValue");
    }

    @Test
    public void shouldBindValueAndNotUseDefault() {
        Pojo pojo = EntityBuilder.entityBuilder(new PojoCreator()).with("name", "newname").get();

        assertThat(pojo.getName()).isEqualTo("newname");
        assertThat(pojo.getValue()).isEqualTo("defaultValue");
    }
}
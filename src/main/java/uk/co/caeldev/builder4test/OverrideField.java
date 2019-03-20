package uk.co.caeldev.builder4test;

import java.util.function.Supplier;

public interface OverrideField<L> {

    <U> L overrideCreator(Field<U> field, Creator<U> creator);
    <U> L overrideSupplier(Field<U> field, Supplier<U> supplier);
    <U> L overrideValue(Field<U> field, U value);

}

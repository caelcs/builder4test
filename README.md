# Builder4test
[![Build Status](https://travis-ci.org/caelwinner/builder4test.svg?branch=master)](https://travis-ci.org/caelwinner/builder4test)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/97f9a4cec6274108af592a20ae31f82b)](https://www.codacy.com/app/adolfoecs/builder4test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=caelwinner/builder4test&amp;utm_campaign=Badge_Grade)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/uk.co.caeldev/builders4test/badge.png?style=flat)](http://search.maven.org/#search|ga|1|g%3A%22uk.co.caeldev%22%20AND%20a%3A%22builders4test%22)

Library to build your POJO entities in a very easy and builder intuitive way.

## Motivation
Most of the time when I am writting my tests I have the need to write clean and readable tests. One way that I found is by having Test Builder but normally it takes time and are difficult to mantain in time. So after looking around I came up with this library to help you to create your pojo in a different and easy way.

## How to use it
the library provides a nice DSL to create your Builders. you only need two steps to have your builder.
### Step 1: 
Write your creator class, this class will be use by the Builder class to create the instance and inject the field values that you want to populate in your pojo.

```java
public class PojoCreator extends Creator<Pojo> {

    @Override
    public Pojo build() {
        return new Pojo(lookup("name", "defaultName"),
                        lookup("value", "defaultValue"));
    }

}
```
### Step 2:
Build your instance by using the following line:

```java
Pojo instance = Builder.build().entity(new PojoCreator()).get();
```
you can override the default value by using the method with:

```java
Pojo instance = Builder.build().entity(new PojoCreator()).with("name", "test1").get();
```
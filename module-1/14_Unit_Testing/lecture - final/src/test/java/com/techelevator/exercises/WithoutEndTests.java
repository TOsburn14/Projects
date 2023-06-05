package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    - "Hello" -> "ell"
    --"abc" -> "b"
    -"ab" -> ""
    "a" -> ""
     "" -> ""
    null -> "" ?



 */

public class WithoutEndTests {

    private WithoutEnd target;

    @Before
    public void setup() {
        target = new WithoutEnd();
    }

    @Test
    public void removes_first_and_last_for_a_string_over_3_characters() {
        String expectedResult = "ell";
        String actualResult = target.withoutEnd("Hello");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returns_one_character_when_given_three() {
        String expectedResult = "b";
        String actualResult = target.withoutEnd("abc");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returns_empty_string_for_2_characters() {
        Assert.assertEquals("", target.withoutEnd("ab"));
    }

    @Test
    public void return_empty_string_for_1_character() {
        Assert.assertEquals("", target.withoutEnd("a"));
    }

    @Test
    public void return_empty_string_for_empty_string() {
        Assert.assertEquals("", target.withoutEnd(""));
    }

    @Test
    public void return_emptry_string_when_null() {
        Assert.assertEquals("", target.withoutEnd(null));
    }


}

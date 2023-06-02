package com.techelevator.exercises;

import org.junit.*;

public class WithoutEndTest {

    private WithoutEnd target;

    @Before
    public void setup() {
        target = new WithoutEnd();
    }

    @Test
    public void removes_first_and_last_for_a_string_over_3_characters() {
        String expectedResult = "ell";
        String actualResult = target.withoutEnd("Hello");
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void returns_one_character_when_given_3() {
        String expectedResult = "b";
        String actualResult = target.withoutEnd("abc");
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void returns_empty_string_when_2_characters_are_used() {
        String expected = "";
        String actual = target.withoutEnd("ab");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void return_empty_string_for_one_character() {
        Assert.assertEquals("", target.withoutEnd("a"));
    }
    @Test
    public void return_empty_string_for_empty_string() {
        Assert.assertEquals("", target.withoutEnd(""));
    }

    @Test
    public void returns_empty_string_when_input_is_null()   {
        String expected = "";
        String actual = target.withoutEnd(null);
        Assert.assertEquals(expected,actual);
    }

}

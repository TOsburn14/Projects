package com.techelevator;
// 1) create class that is nameOfClassBeingTestedTests


// 2) import org.junit.*
import org.junit.*;

public class AnimalGroupNameTests {

    // 3) Create a member variable for the object being tested
    private AnimalGroupName target;

    // 4) create a before method that instantiates the object being tested before each test is run
    @Before
    public void setup() {
        target = new AnimalGroupName();
    }

    // 5) Write your tests
    @Test
    public void animal_name_is_not_case_sensitive() {
        String inputAnimalName = "cRoW";
        String expectedResult = "Murder";
        String actualResult = target.getHerd(inputAnimalName);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void animal_name_returns_correct_herd() {
        Assert.assertEquals("Pack", target.getHerd("Dog"));
    }
}

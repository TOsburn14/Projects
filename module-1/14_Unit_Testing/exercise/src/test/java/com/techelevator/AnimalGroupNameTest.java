package com.techelevator;
import org.junit.*;


public class AnimalGroupNameTest {
    private AnimalGroupName target;

    @Before
    public void setup(){
        target = new AnimalGroupName();
    }

    @Test
    public void verify_animal_name_is_not_case_sensitive(){
        String inputAnimalName = "cRoW";
        String expected = "Murder";
        String actual = target.getHerd(inputAnimalName);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void animal_name_returns_correct_herd(){
        Assert.assertEquals("Pack",target.getHerd("Dog"));
    }
    @Test
    public void animal_name_empty_returns_unknown(){
        Assert.assertEquals("unknown",target.getHerd(""));
    }
    @Test
    public void animal_name_not_found_returns_unknown(){
        Assert.assertEquals("unknown",target.getHerd("Pig"));
    }
    @Test
    public void animal_name_null_returns_unknown(){
        Assert.assertEquals("unknown",target.getHerd(null));
    }
}

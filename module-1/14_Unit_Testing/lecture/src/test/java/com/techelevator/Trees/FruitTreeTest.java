package com.techelevator.Trees;

/*
    1.) pickFruit returns true if enough fruit is left on tree
    2.) pick 0 fruit
    3.) pick -1 fruit
    4.) pick all fruit
    5.) pick too much fruit
    6.) the tree has the right type of fruit
    7.) tree has null fruit
    8.) can pick fruit multiple times
 */

import com.techelevator.trees.FruitTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {

    private FruitTree target;


    @Before
    public void setup() {
    target = new FruitTree("Pear",10);
    }
    @Test
    public void pick_fruit_successful() {
        // Arrange (Setup)
        // Act (Test)
        boolean couldPickFruit = target.pickFruit(5);
        // Asset (Verify)
        Assert.assertTrue("Picked Fruit returned false", couldPickFruit);
        int numberOfPiecesLeft = target.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", 5, numberOfPiecesLeft);
    }

    @Test
    public void pick_zero_fruit() {
        Assert.assertTrue(target.pickFruit(0));
        Assert.assertEquals(10, target.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_negative_fruit() {
        Assert.assertFalse("Pick Fruit return true instead false",target.pickFruit(-1));
        Assert.assertEquals(10,target.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_all_fruit() {
        Assert.assertTrue(target.pickFruit(10));
        Assert.assertEquals(0,target.getPiecesOfFruitLeft());
    }
    @Test
    public void pick_too_much_fruit() {
        Assert.assertFalse(target.pickFruit(10 + 1));
        Assert.assertEquals(10,target.getPiecesOfFruitLeft());
    }
    @Test
    public void is_fruit_the_right_type(){
        Assert.assertEquals("Pear",target.getTypeOfFruit());
    }
    @Test
    public void tree_has_null_fruit(){
        FruitTree treeWithNullFruit = new FruitTree(null,10);
        Assert.assertNull(treeWithNullFruit.getTypeOfFruit());
    }
    @Test
    public void can_fruit_be_picked_multiple_times(){
        //Arrange
        target.pickFruit(3);
        //Act
        Assert.assertTrue(target.pickFruit(4));
        Assert.assertEquals(10 - 3 - 4, target.getPiecesOfFruitLeft());
    }

}

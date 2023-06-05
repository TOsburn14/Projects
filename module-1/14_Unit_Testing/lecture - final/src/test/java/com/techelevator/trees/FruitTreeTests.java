package com.techelevator.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    - 1) pickFruit returns true if enough fruit left on tree
    - 2) pick 0 fruit
    - 3) pick -1 fruit
    - 4) pick all the fruit
    - 5) pick too much fruit
    - 6) the tree has the right type of fruit
    - 7) the tree has null fruit
    8) can pick fruit multiple times
 */
public class FruitTreeTests {

    private static final int START_NUMBER_OF_FRUIT = 10;

    private FruitTree target;

    @Before
    public void setup() {
        target = new FruitTree("Pear", START_NUMBER_OF_FRUIT);
    }

    @Test
    public void pick_fruit_when_enough_fruit() {
        // Arrange (Setup)
        // Act (Test)
        boolean couldPickFruit = target.pickFruit(5);
        // Assert (Verify)
        Assert.assertTrue("Pickfruit returned false", couldPickFruit);
        int numberOfPiecesLeftOnTree = target.getPiecesOfFruitLeft();
        Assert.assertEquals("Wrong number of fruit remaining", START_NUMBER_OF_FRUIT - 5, numberOfPiecesLeftOnTree);
    }

    @Test
    public void pick_zero_fruit() {
        // Arrange
        // Act & Assert
        Assert.assertTrue( target.pickFruit(0) );
        Assert.assertEquals(START_NUMBER_OF_FRUIT, target.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_negative_fruit() {
        Assert.assertFalse("pickFruit returned true instead of false", target.pickFruit(-1) );
        Assert.assertEquals(START_NUMBER_OF_FRUIT, target.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_all_the_fruit() {
        Assert.assertTrue(target.pickFruit(START_NUMBER_OF_FRUIT));
        Assert.assertEquals(0, target.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_too_much_fruit() {
        Assert.assertFalse(target.pickFruit(START_NUMBER_OF_FRUIT + 1));
        Assert.assertEquals(START_NUMBER_OF_FRUIT, target.getPiecesOfFruitLeft());
    }

    @Test
    public void tree_has_correct_type_of_fruit() {
        Assert.assertEquals("Pear", target.getTypeOfFruit());
    }

    @Test
    public void tree_has_null_type_of_fruit() {
        FruitTree treeWithNullFruit = new FruitTree(null, 10);
        Assert.assertNull(treeWithNullFruit.getTypeOfFruit());
    }

    @Test
    public void can_pick_fruit_multiple_times() {
        // Arrange
        target.pickFruit(3);
        // Act
        Assert.assertTrue(target.pickFruit(4));
        // Assert
        Assert.assertEquals(START_NUMBER_OF_FRUIT - 3 - 4, target.getPiecesOfFruitLeft());
    }

}

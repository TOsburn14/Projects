package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {
    private CigarParty target;

    @Before
    public void setup(){
        target = new CigarParty();
    }
    @Test
    public void do_squirrels_have_enough_cigars_not_weekend(){
       boolean result = target.haveParty(40,false);
       Assert.assertTrue(result);
    }
    @Test
    public void do_squirrels_have_too_many_cigars_not_weekend(){
        boolean result = target.haveParty(61,false);
        Assert.assertFalse(result);
    }
    @Test
    public void do_squirrels_have_enough_cigars_for_party(){
        boolean result = target.haveParty(39, true);
        Assert.assertFalse(result);
    }
    @Test
    public void do_squirrels_have_cigar_party_on_weekend(){
        boolean result = target.haveParty(71,true) ;
        Assert.assertTrue(result);
    }

}

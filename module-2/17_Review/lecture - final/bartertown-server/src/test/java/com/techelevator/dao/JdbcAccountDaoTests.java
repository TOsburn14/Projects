package com.techelevator.dao;

import com.techelevator.bartertown.dao.AccountDao;
import com.techelevator.bartertown.dao.JdbcAccountDao;
import com.techelevator.bartertown.model.Account;
import org.junit.*;

public class JdbcAccountDaoTests extends BaseDaoTests {

    private AccountDao sut;

    @Before
    public void setup() {
        sut = new JdbcAccountDao(dataSource);
    }

    @Test
    public void get_barter_credits_for_user() {
        Account account = sut.getAccountForUser(1001);
        Assert.assertEquals(10, account.getBarterCredit());
    }

}

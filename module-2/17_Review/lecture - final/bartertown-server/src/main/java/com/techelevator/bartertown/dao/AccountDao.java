package com.techelevator.bartertown.dao;

import com.techelevator.bartertown.model.Account;

public interface AccountDao {

    Account getAccountForUser(int userId);
}

package com.techelevator.bartertown.dao;

import com.techelevator.bartertown.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int id);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password);
}
/*
SELECT offer_id, offer_status_desc, userTo.username AS user_to, userFrom.username AS user_from, item FROM offer
JOIN offer_status ON offer_status.offer_status_id = offer.offer_status_id
JOIN account acctTo ON acctTo.account_id = offer.account_to
JOIN bartertown_user userTo ON userTo.user_id = acctTo.user_id
JOIN account acctFrom ON acctFrom.account_id = offer.account_from
JOIN bartertown_user userFrom ON userFrom.user_id = acctFrom.user_id
 */
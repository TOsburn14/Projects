package com.techelevator.bartertown.controller;

import com.techelevator.bartertown.dao.AccountDao;
import com.techelevator.bartertown.dao.UserDao;
import com.techelevator.bartertown.model.Account;
import com.techelevator.bartertown.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/accounts")
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDao accountDao;
    private UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao){
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Account getAccountForUser(Principal principal){
        String username = principal.getName();
        int userId = userDao.findIdByUsername(username);
        Account account = accountDao.getAccountForUser(userId);
        return account;
    }
}

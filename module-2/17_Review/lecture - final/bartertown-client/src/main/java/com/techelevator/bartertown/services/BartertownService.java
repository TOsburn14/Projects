package com.techelevator.bartertown.services;

import com.techelevator.bartertown.model.Account;
import com.techelevator.bartertown.model.AuthenticatedUser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class BartertownService {

    private final RestTemplate restTemplate = new RestTemplate();

    private String apiBaseUrl;
    private AuthenticatedUser currentUser;

    public BartertownService(String apiBaseUrl, AuthenticatedUser currentUser) {
        this.apiBaseUrl = apiBaseUrl;
        this.currentUser = currentUser;
    }

    public Account getAccountForUser() {
        String url = apiBaseUrl + "accounts";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth( currentUser.getToken() );
        HttpEntity<Void> request = new HttpEntity<Void>(httpHeaders);

        ResponseEntity<Account> response = restTemplate.exchange(url, HttpMethod.GET, request, Account.class);
        Account accountReturnedFromApi = response.getBody();
        return accountReturnedFromApi;
    }

}

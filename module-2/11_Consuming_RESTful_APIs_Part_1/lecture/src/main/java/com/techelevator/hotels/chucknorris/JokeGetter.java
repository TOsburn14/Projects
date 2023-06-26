package com.techelevator.hotels.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeGetter {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.chucknorris.io/jokes/random?category=dev";

        Joke joke = restTemplate.getForObject(url,Joke.class);

        System.out.println(joke.getValue());


    }
}

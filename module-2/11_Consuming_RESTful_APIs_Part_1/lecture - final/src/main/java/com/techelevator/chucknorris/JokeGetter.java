package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class JokeGetter {

    public static void main(String[] args) {

        // 1) Instantiate a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // 2) Build the URL
        String url = "https://api.chucknorris.io/jokes/random?category=dev";

        // 3) Call the API with the URL and identify the returned data type
        Joke joke = restTemplate.getForObject(url, Joke.class);



        System.out.println(joke.getValue());

    }
}

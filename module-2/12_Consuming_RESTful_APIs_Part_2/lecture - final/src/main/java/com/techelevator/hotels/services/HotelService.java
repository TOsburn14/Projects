package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;

        try {

            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (ResourceAccessException e) {
            // ResourceAccessException is thrown when the server cannot be reached
            // for example: no internet connection, server down, wrong address, etc.
            BasicLogger.log("Unable to connect to server");
        } catch (RestClientResponseException e) {
            // RestClientResponseException is thrown when the server responds with
            // a 4xx or 5xx status code
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }
        return hotels;
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {

        String url = API_BASE_URL + "hotels/" +  newReservation.getHotelId() + "/reservations";

        // 1) Create a Header and set the content type to JSON
        // 2) Set the message body to the reservation object
        // 3) Send the request with the header and the message body (from 1 and 2)
        // 4) Receive the response and return it
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        HttpEntity<Reservation> httpEntity = new HttpEntity<Reservation>(newReservation, headers);

        Reservation returnedReservation = null;
        try {
            returnedReservation = restTemplate.postForObject(url, httpEntity, Reservation.class);
        } catch (ResourceAccessException e) {
            BasicLogger.log("Unable to connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }
        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        boolean wasSuccessful = false;
        String url = API_BASE_URL + "reservations/" + updatedReservation.getId();

        // 1) Create header object
        // 2) Set the Content Type to application/json
        // 3) Create an HttpEntity<T> where T is the data type that will form the message body
        // 4) Pass the HttpEntity the object (reservation) with the data and the headers
        // 5) Send the put request using the put() method of the RestTemplate
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        HttpEntity<Reservation> httpEntity = new HttpEntity<Reservation>(updatedReservation, headers);

        try {
            restTemplate.put(url, httpEntity);
            wasSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Unable to connect to Server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return wasSuccessful;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        boolean wasSuccessful = false;
        try {
            // 1. Call the delete() method on the RestTemplate and pass it the URL
            restTemplate.delete(API_BASE_URL + "reservations/" + id );
            wasSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Cannot connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return wasSuccessful;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}
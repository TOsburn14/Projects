package com.techelevator.hotels;

import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    public static final int LIST_HOTELS = 1;
    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();

            /*
                This code is not readable - how could we improve it?
             */
            if (menuSelection == LIST_HOTELS) {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == 2) {
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            } else if (menuSelection == 3) {
                Hotel hotelWithId1 = hotelService.getHotelById(1);
                consoleService.printHotel( hotelWithId1 );

//                int hotelId = consoleService.getHotelId();
//                Hotel hotelWithUserInputId = hotelService.getHotelById(hotelId);
//                consoleService.printHotel(hotelWithUserInputId);

            } else if (menuSelection == 4) {
                Review[] reviewsForHotel1 = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviewsForHotel1);
            } else if (menuSelection == 5) {
                Hotel[] hotelsWith3Stars = hotelService.getHotelsByStarRating(3);
                consoleService.printHotels(hotelsWith3Stars);
            } else if (menuSelection == 6) {
                Country country = hotelService.getWithCustomQuery();
                System.out.println(country);
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}

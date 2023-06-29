package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path="/hotels", method=RequestMethod.GET)
    public List<Hotel> listAllHotels(@RequestParam(required=false) String state,
                                     @RequestParam(required=false) String city,
                                     @RequestParam(required=false, defaultValue="0") double maxCostPerNight) {
        List<Hotel> filteredList = hotelDao.getFilteredList(state, city);
        
        if (maxCostPerNight > 0) {
            List<Hotel> tempList = new ArrayList<Hotel>();
            for (Hotel hotel : filteredList) {
                if (hotel.getCostPerNight() <= maxCostPerNight) {
                    tempList.add(hotel);
                }
            }
            filteredList = tempList;
        }

        return filteredList;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)
    public Hotel getHotelById(@PathVariable int id) {
        return hotelDao.get(id);
    }

    @RequestMapping(path="/hotels/{hotelId}/reservations", method=RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable int hotelId) {
        return reservationDao.findByHotel(hotelId);
    }

    @RequestMapping(path="/hotels/{hotelId}/reservations", method=RequestMethod.POST)
    public Reservation add(@PathVariable int hotelId, @RequestBody Reservation reservation) {
        return reservationDao.create(reservation, hotelId);
    }

}

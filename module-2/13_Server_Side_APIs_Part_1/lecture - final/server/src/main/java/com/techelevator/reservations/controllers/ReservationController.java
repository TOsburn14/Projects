package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationDao reservationDao;

    public ReservationController() {
        reservationDao = new MemoryReservationDao(new MemoryHotelDao());
    }

    @RequestMapping(path="", method= RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public Reservation getReservationById(@PathVariable("id") int reservationId) {
        return reservationDao.get(reservationId);
    }



}

package com.aberk.reservation;

import java.util.List;

import com.aberk.reservation.model.ReservationModel;
import com.aberk.reservation.repository.Reservation;
import com.aberk.reservation.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResController{
    
	@Autowired
    private ReservationRepository repository;

    // =Create Reservation=
    // ex: POST-> localhost:8080/reservation 
    // body should like->
    // {
    //	"name": "sabah Yemegi",
    //	"date": "cuma"
    // }
    @RequestMapping(value="/reservation", method = RequestMethod.POST)
    public String createReservation(@RequestBody ReservationModel payload){

        repository.save(new Reservation(payload.getName(), payload.getDate()));
        return "Done";
    }

    // =GET all reservation=
    // ex: GET-> localhost:8080/reservation
    @RequestMapping(value="/reservation", method = RequestMethod.GET)
    public List<Reservation> getReservationList(){
        List<Reservation> list = (List<Reservation>) repository.findAll();
        return list;
    }

    // =List reservations by paging or sorting=
    // ex: GET-> localhost:8080/respage?page=2&size=3
    // ex: GET-> http://localhost:8080/respage?page=0&size=6&sort=name 
    @RequestMapping(value="/respage", method = RequestMethod.GET)
    Page <Reservation> reservationPageable (Pageable pageable){
        return repository.findAll(pageable);
    }
}
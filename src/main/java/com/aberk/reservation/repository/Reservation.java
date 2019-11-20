package com.aberk.reservation.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String date;

    
    public Reservation(String name, String date) {
        this.name = name;
        this.date = date;
    }
    public String getName() {
        return name;
    }
    
    public String getDate() {
        return date;
    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation name: " + name + "\n" + "date: " + date;
    }

    
}
package com.aberk.reservation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>, JpaRepository<Reservation, Integer> {

	Page<Reservation> findAll(Pageable pageable);
}


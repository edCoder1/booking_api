package com.example.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

//  review documentation: docs.spring.io/spring-data/jpa...
    public List<HotelBooking> findByPricePerNightLessThan(double price);
}

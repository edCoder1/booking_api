package com.example.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

//    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriot", 200.5, 3));
        bookings.add(new HotelBooking("Ibis", 90.5, 4));
        bookings.add(new HotelBooking("Novotel", 180.5, 1));

         bookingRepository.saveAll(bookings);
    }
}

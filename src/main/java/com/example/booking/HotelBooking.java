package com.example.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int numberOfNights;


    public long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalPrice(){
        return pricePerNight * numberOfNights;
    }

    public HotelBooking(String hotelName, double pricePerNight, int numberOfNights){
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
    }

    // Needed because @Entity requires it.. don't know why
    public HotelBooking(){}
}

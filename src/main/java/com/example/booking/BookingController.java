package com.example.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/bookings")
@Api(
        name = "Hotel Booking API",
        description = "Provides a list o records for Hotel Booking purposes",
        stage = ApiStage.BETA
)
public class  BookingController {

    private BookingRepository bookingRepository;

//    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get a list of all Hotels in Database")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get a list of all Hotels in DB below price of the given path parameter")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price", description = "price value reference") @PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Creates a new Hotel record from DB")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Deletes a Hotel record in DB")
    public List<HotelBooking> deleteOneById( @ApiPathParam(name = "id", description = "id of record to be deleted") @PathVariable long id){

//        try {
            bookingRepository.deleteById(id);
            return  bookingRepository.findAll();
//        } catch (EmptyResultDataAccessException e) {
//            throw new EmptyResultDataAccessException(1);
//        }

    }


}
package com.rent.controller;

import com.rent.dto.BookingReqDto;
import com.rent.dto.BookingRespDto;
import com.rent.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Slf4j
public class BookingController {

    @Autowired
    private BookingService itemService;

    @PostMapping("/api/bookings")
    public ResponseEntity<BookingRespDto> createBooking(@RequestBody BookingReqDto bookingReqDto, Principal principal) {

        log.info("Received Request to make new booking");
        BookingRespDto bookingRespDto = itemService.createBooking(bookingReqDto,principal);
        log.info("Booking Created Successfully");
        return new ResponseEntity<>(bookingRespDto, HttpStatus.OK);
    }

    @PatchMapping("/api/bookings/{id}/approve")
    public ResponseEntity<BookingRespDto> approveBooking(@PathVariable Long id) {
        log.info("Received Request to approve booking");
        BookingRespDto bookingRespDto = itemService.approveBooking(id);
        log.info("Booking Approved Successfully");
        return new ResponseEntity<>(bookingRespDto, HttpStatus.OK);
    }



}

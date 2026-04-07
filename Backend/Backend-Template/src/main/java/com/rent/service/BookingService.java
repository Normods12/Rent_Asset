package com.rent.service;

import com.rent.dto.BookingReqDto;
import com.rent.dto.BookingRespDto;
import com.rent.entity.Booking;
import com.rent.entity.BookingStatus;
import com.rent.entity.Items;
import com.rent.entity.Users;
import com.rent.exception.ResourceNotFoundException;
import com.rent.mapper.BookingMapper;
import com.rent.repository.BookingRepo;
import com.rent.repository.ItemsRepo;
import com.rent.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ItemsRepo itemsRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookingMapper bmap;

    public BookingRespDto createBooking(BookingReqDto  bookingDto, Principal principal) {
        log.info("Booking is being created...");
        log.debug("Checking if item exists");
        Items item = itemsRepo.findById(bookingDto.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        log.info("Item found");
        log.debug("Validating user");
        Users user = userRepo.findByEmail(principal.getName());
        if(user==null){
            log.warn("User not found");
            throw new ResourceNotFoundException("User not found");
        }
       Booking booking = bmap.reqToDto(bookingDto,item,user);
        log.info("Booking is created");
        bookingRepo.save(booking);
        return bmap.dtoToRes(booking);
    }

    public BookingRespDto approveBooking(Long id){
        log.debug("Validating booking details");
        Booking booking  = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        booking.setStatus(BookingStatus.APPROVED);
        log.info("Booking is approved");
        bookingRepo.save(booking);
        return bmap.dtoToRes(booking);
    }

}

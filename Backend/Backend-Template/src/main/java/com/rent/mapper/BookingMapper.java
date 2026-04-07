package com.rent.mapper;

import com.rent.dto.BookingReqDto;
import com.rent.dto.BookingRespDto;
import com.rent.entity.Booking;
import com.rent.entity.Items;
import com.rent.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public Booking reqToDto(BookingReqDto bookingDto, Items item, Users user) {
        Booking booking = new Booking();
        booking.setPurpose(bookingDto.getPurpose());
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());
        booking.setItem(item);
        booking.setBorrower(user);
        return booking;
    }

    public BookingRespDto dtoToRes(Booking booking){
        BookingRespDto bookingRespDto = new BookingRespDto();
        bookingRespDto.setId(booking.getId());
        bookingRespDto.setPurpose(booking.getPurpose());
        bookingRespDto.setStartDate(booking.getStartDate());
        bookingRespDto.setEndDate(booking.getEndDate());
        bookingRespDto.setStatus(booking.getStatus());
        bookingRespDto.setItem_name(booking.getItem().getName());
        bookingRespDto.setBorrower_name(booking.getBorrower().getFirstName());
        return bookingRespDto;
    }

}

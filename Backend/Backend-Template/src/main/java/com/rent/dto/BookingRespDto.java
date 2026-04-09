package com.rent.dto;


import com.rent.entity.BookingStatus;
import com.rent.entity.Items;
import com.rent.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRespDto {


    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String purpose;

    private BookingStatus status;

    private String borrower_name;

    private String item_name;
}

package com.rent.dto;


import com.rent.entity.BookingStatus;
import com.rent.entity.Items;
import com.rent.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRespDto {


    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String purpose;

    private BookingStatus status;

    private String borrower_name;

    private String item_name;
}

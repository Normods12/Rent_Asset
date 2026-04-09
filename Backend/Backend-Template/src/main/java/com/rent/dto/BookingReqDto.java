package com.rent.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingReqDto {

    @NotNull(message = "Date should not be empty")
    private LocalDate startDate;
    @NotNull(message = "Date should not be empty")
    private LocalDate endDate;
    @NotBlank(message = "Purpose should not be empty")
    private String purpose;
    @NotNull(message = "Item Id should not be null")
    private Long itemId;
}

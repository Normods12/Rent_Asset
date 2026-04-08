package com.rent.dto;

import lombok.Data;

@Data
public class ItemCreationDto {

    private String name;
    private String description;
    private String category;
    private Double dailyRate;
}

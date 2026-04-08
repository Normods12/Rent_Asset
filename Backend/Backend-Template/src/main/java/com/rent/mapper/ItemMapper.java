package com.rent.mapper;

import com.rent.dto.ItemCreationDto;
import com.rent.entity.Items;

public class ItemMapper {

    public Items toEntity(ItemCreationDto itemCreationDto) {
        Items item = new Items();
        item.setName(itemCreationDto.getName());
        item.setDescription(itemCreationDto.getDescription());
        item.setCategory(itemCreationDto.getCategory());
        item.setDailyRate(itemCreationDto.getDailyRate());
        return item;
    }

}

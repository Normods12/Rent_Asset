package com.rent.mapper;

import com.rent.dto.ItemCreationDto;
import com.rent.entity.Items;

import java.util.List;

public class ItemMapper {

    public Items toEntity(ItemCreationDto itemCreationDto) {
        Items item = new Items();
        item.setName(itemCreationDto.getName());
        item.setDescription(itemCreationDto.getDescription());
        item.setCategory(itemCreationDto.getCategory());
        item.setDailyRate(itemCreationDto.getDailyRate());
        return item;
    }

    public List<ItemCreationDto> toDtoList(List<Items> itemsList) {

        return itemsList.stream().map(item -> {
            ItemCreationDto dto = new ItemCreationDto();
            dto.setName(item.getName());
            dto.setDescription(item.getDescription());
            dto.setCategory(item.getCategory());
            dto.setDailyRate(item.getDailyRate());
            return dto;
        }).toList();
    }
}

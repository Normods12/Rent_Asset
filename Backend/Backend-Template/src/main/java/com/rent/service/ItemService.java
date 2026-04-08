package com.rent.service;

import com.rent.dto.ItemCreationDto;
import com.rent.entity.Items;
import com.rent.mapper.ItemMapper;
import com.rent.repository.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemsRepo itemsRepo;
    private ItemMapper itemMapper;

    public ItemCreationDto save(ItemCreationDto itemCreationDto) {

        Items item= itemMapper.toEntity(itemCreationDto);
        itemsRepo.save(item);
        return itemCreationDto;
    }
}

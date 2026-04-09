package com.rent.service;

import com.rent.dto.ItemCreationDto;
import com.rent.entity.Items;
import com.rent.entity.Users;
import com.rent.mapper.ItemMapper;
import com.rent.repository.ItemsRepo;
import com.rent.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemsRepo itemsRepo;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private UserRepo userRepo;

    public ItemCreationDto save(ItemCreationDto itemCreationDto, Principal principal) {
        Users user = userRepo.findByEmail(principal.getName());
        Items item= itemMapper.toEntity(itemCreationDto);
        item.setOwner(user);
        itemsRepo.save(item);
        return itemCreationDto;
    }

    public List<ItemCreationDto> getAllItems() {
        List<Items> itemsList = itemsRepo.findAll();
        return itemMapper.toDtoList(itemsList);
    }
}

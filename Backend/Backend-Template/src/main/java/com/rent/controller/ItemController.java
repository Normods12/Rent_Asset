package com.rent.controller;

import com.rent.dto.ItemCreationDto;
import com.rent.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemCreationDto> createItem(@RequestBody ItemCreationDto item) {

        return  new ResponseEntity<>(itemService.save(item), HttpStatus.CREATED);
    }


}

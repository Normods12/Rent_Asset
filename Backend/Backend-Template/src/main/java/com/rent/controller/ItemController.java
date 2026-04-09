package com.rent.controller;

import com.rent.dto.ItemCreationDto;
import com.rent.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemCreationDto> createItem(@RequestBody ItemCreationDto item, Principal principal) {

        return  new ResponseEntity<>(itemService.save(item,principal), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemCreationDto>> getAllItems() {

        return  new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }


}

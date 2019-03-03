package com.goal.rss.controller;

import com.goal.rss.jaxb.Item;
import com.goal.rss.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by p.gharibi on 3/2/2019.
 */

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping("/api/items")
    public List<Item> getLastTen(){
        return itemService.getLastTen();
    }


}

package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.Item;
import com.thoughtworks.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemServiceImpl;

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public @ResponseBody Item getItemById(@PathVariable int id){
        return itemServiceImpl. getItemById(id);
    }
}

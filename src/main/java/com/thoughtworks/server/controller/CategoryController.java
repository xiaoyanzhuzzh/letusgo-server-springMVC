package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.Category;
import com.thoughtworks.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryServiceImpl;

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody Category getCategoryById(@PathVariable int id){
//        System.out.println(categoryServiceImpl.getCategoryById(id));

        return categoryServiceImpl.getCategoryById(id);
//        int intId = Integer.parseInt(id);
//        Category category = categoryServiceImpl.getCategoryById(id);
//        modelMap.addAttribute("category", category);
//        return "category";
    }

//    @RequestMapping(value="/delete",method = RequestMethod.GET)
//    public String printWelcome(@RequestParam("id") String id, ModelMap model) {
//        int itemId = Integer.parseInt(id);
//        //String mess = itemService.getItemById(itemId);
//        Category category = categoryServiceImpl.getCategoryById(itemId);
//        model.addAttribute("message", category);
//        return "category";
//    }

}

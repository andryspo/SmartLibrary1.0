package com.controllers;

import com.entities.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping(value = "/")
    public ModelAndView getPage(){
        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSaved(@RequestBody Book book) {

        Map<String, Object> map = new HashMap<String,Object>();

        service.saveOrUpdate(book);
        map.put("status", "200");
        map.put("message", "Your book have been saved succesfully");

        return map;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<String,Object>();
        List<Book> list = service.list();

        if(list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else{
            map.put("status", "404");
            map.put("message", "Data not found");
        }

        return map;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> deleteBook(@RequestBody int id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Book book = service.getBooks(id);
        service.delete(book);
        map.put("status", "200");
        map.put("message", "Your book have been deleted");

        return map;
    }
}

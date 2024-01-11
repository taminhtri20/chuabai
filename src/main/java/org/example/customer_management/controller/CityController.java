package org.example.customer_management.controller;

import org.example.customer_management.service.HibernateCityService;
import org.example.customer_management.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CustomerController {
    @Autowired
    ICityService cityService = new HibernateCityService();
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listCity", cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/update");

        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");

        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");

        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");

        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam(value = "name", required = false) String name){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }
}

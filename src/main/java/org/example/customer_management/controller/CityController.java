package org.example.customer_management.controller;

import org.example.customer_management.model.City;
import org.example.customer_management.respository.NationRepository;
import org.example.customer_management.service.HibernateCityService;
import org.example.customer_management.service.HibernateNationService;
import org.example.customer_management.service.ICityService;
import org.example.customer_management.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    ICityService cityService = new HibernateCityService();
    @Autowired
    INationService nationService = new HibernateNationService();

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listCity", cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("nation", nationService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(City city){
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.edit(city.getId(), new City(city.getNameCity(),city.getNameNation(), city.getArea(), city.getPopulation(), city.getGdp(), city.getDescription()));
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(City city){
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.remove(city.getId());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView create(City city){
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        cityService.save(city);
        return modelAndView;
    }
}

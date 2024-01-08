package org.example.customer_management.controller;

import org.example.customer_management.model.Customer;
import org.example.customer_management.respository.CustomerRepository;
import org.example.customer_management.service.HibernateCustomerService;
import org.example.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService = new HibernateCustomerService();
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listCustomer", customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("customer", customerService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.edit(customer.getId(), new Customer(customer.getName(), customer.getEmail(), customer.getAddress()));
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.remove(customer.getId());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView create(Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        customerService.save(new Customer(customer.getName(), customer.getEmail(), customer.getAddress()));
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam(value = "name", required = false) String name){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listCustomer", customerService.findByName(name));
        return modelAndView;
    }
}

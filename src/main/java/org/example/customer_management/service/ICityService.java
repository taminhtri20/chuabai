package org.example.customer_management.service;

import org.example.customer_management.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> findAll();
    void save(City city);
    Optional<City> findById(int id);
    void remove(int id);
    void edit(int id, City city);
    List<City> findByName(String name);
}

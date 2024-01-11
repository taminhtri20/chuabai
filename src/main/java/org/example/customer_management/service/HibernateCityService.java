package org.example.customer_management.service;

import org.example.customer_management.model.City;
import org.example.customer_management.respository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HibernateCityService implements ICityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(new City(city.getNameCity(), city.getNameNation(), city.getArea(), city.getPopulation(), city.getGdp(), city.getDescription()));
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        cityRepository.deleteById(id);
    }
    @Override
    public void edit(int id, City city) {
        cityRepository.save(new City(id, city.getNameCity(), city.getNameNation(), city.getArea(), city.getPopulation(), city.getGdp(), city.getDescription()));
    }

    @Override
    public List<City> findByName(String name) {
        List<City> customerList = cityRepository.findByNameCityContainsIgnoreCase(name);
        return customerList;
    }
}

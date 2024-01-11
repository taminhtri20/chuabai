package org.example.customer_management.respository;

import org.example.customer_management.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByNameCityContainsIgnoreCase(String name);
}

package org.example.customer_management.service;

import org.example.customer_management.model.City;
import org.example.customer_management.model.Nation;
import org.example.customer_management.respository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateNationService implements INationService{
    @Autowired
    NationRepository nationRepository;
    @Override
    public List<Nation> findAll() {
        return nationRepository.findAll();
    }
}

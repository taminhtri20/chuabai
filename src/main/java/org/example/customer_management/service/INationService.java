package org.example.customer_management.service;

import org.example.customer_management.model.City;
import org.example.customer_management.model.Nation;

import java.util.List;

public interface INationService {
    List<Nation> findAll();
}

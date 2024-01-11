package org.example.customer_management.respository;

import org.example.customer_management.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationRepository extends JpaRepository<Nation, Integer> {
    List<Nation> findAll();
}

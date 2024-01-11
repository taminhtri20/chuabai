package org.example.customer_management.model;

import javax.persistence.*;

@Entity
public class nameCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
    public nameCity(){}
    public nameCity(int id, String nameCity){
        this.id = id;
        this.nameCity = nameCity;
    }
    public nameCity(String nameCity){
        this.nameCity = nameCity;
    }
}

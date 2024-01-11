package org.example.customer_management.model;

import javax.persistence.*;

@Entity
@Table(name = "nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
    public Nation(){}
    public Nation(int id, String nameCity){
        this.id = id;
        this.nameCity = nameCity;
    }
    public Nation(String nameCity){
        this.nameCity = nameCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}

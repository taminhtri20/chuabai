package org.example.customer_management.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCity;
    private String nameNation;
    private int area;
    private int population;
    private int gdp;
    private String description;
    public City(){}
    public City(int id, String nameCity, String nameNation, int area, int population, int gdp, String description){
        this.id = id;
        this.nameCity = nameCity;
        this.nameNation = nameNation;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }
    public City(String nameCity, String nameNation, int area, int population, int gdp, String description){
        this.nameCity = nameCity;
        this.nameNation = nameNation;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

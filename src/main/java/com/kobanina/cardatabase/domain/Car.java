package com.kobanina.cardatabase.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    @Column(name="`year`")
    private int year;
    private int price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car() {}

    public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

package com.soundms.musicstorebackend.instrument;

import jakarta.persistence.*;

@Entity
@Table(name = "instrument")
public class Instrument {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instrument")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    //Constructor
    public Instrument(){}
    public Instrument(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

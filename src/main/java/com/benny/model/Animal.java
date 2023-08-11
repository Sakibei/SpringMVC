package com.benny.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

//沒有開啟ddl_auto功能所以不會建立表格
@Entity
@Table(name="animal")
@Component
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String animalName;

    public Animal(){}

    public Animal(int aid, String animalName) {
        this.aid = aid;
        this.animalName = animalName;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}

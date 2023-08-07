package com.benny.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "house")
public class House implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "HOUSEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int houseid;
    @Column(name = "HOUSENAME")
    private String housename;

    public House() {
    }

    public House(String name) {
        this.housename = name;
    }

    public House(int id, String name) {
        this.houseid = id;
        this.housename = name;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }
}

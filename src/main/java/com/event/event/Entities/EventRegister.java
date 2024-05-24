package com.event.event.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "eventInformation")
public class EventRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String date;

    private String location;
    private String registrationDetail;







    public EventRegister() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistrationDetail() {
        return registrationDetail;
    }

    public void setRegistrationDetail(String registrationDetail) {
        this.registrationDetail = registrationDetail;
    }


}

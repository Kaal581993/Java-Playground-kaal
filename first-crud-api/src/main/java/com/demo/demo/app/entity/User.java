package com.demo.demo.app.entity;

import lombok.Getter;
import lombok.Setter;

//POJO classes -> Plain Old Java Class
@Setter
@Getter
public class User {

    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id=id;
        this.name=name;
        this.email=email;
    }


}

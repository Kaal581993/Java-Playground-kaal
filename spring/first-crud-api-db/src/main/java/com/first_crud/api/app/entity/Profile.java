package com.first_crud.api.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Profile {
    public Profile() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bio;
    private String phone;

    public Profile(String bio, String phone) {
        this.bio = bio;
        this.phone = phone;
    }

    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
}

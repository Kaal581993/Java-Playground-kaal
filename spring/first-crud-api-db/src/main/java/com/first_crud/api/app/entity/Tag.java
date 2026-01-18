package com.first_crud.api.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Posts> posts;


}

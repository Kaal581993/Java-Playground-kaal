package com.first_crud.api.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name= "user_id")
    @JsonIgnore
    private User user;

    public Posts() {
    }

    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Posts(String title, String content, User user, List<Tag> tags) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.tags = tags;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="post_tags",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    @JsonIgnore
    private List<Tag> tags;


}

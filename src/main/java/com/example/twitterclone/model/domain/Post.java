package com.example.twitterclone.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

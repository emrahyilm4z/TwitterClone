package com.emrah.TwitterClone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FOLLOWERS")
public class Follower {
    @Id
    private int id;

    private String userName;

    @JsonManagedReference
    @ManyToMany(mappedBy = "followers",fetch = FetchType.LAZY,  cascade = {CascadeType.MERGE})
    private Set<User> users = new HashSet<>();


}

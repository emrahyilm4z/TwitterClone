package com.emrah.TwitterClone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "userInfo")
    private String userInfo;

    @Column(name = "location")
    private String location;

    @Column(name = "birthDay")
    private LocalDate birthDay;

    @Column(name = "createDate")
    private LocalDate userCreateDate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Tweet> tweets;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "followedUsers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    @JsonManagedReference
    private Set<Follower> followers = new HashSet<>();

    public void addFollower(Follower follower){
        followers.add(follower);
    }
}

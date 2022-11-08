package com.emrah.TwitterClone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Tweet> tweets;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = {CascadeType.DETACH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.MERGE} )
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
    public void unFollower(Follower follower){
        followers.remove(follower);}
}

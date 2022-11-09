package com.emrah.TwitterClone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


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
    @CreationTimestamp
    private LocalDateTime userCreateDate;

    @ElementCollection
    private List<Integer> likes = new ArrayList<>();

    public void like(int tweetId){
        likes.add(tweetId);
    }
    public void noLike(int tweetId){
        likes.remove(tweetId);
    }

    @ElementCollection
    private Map<Integer, LocalDateTime> reTweets = new HashMap<Integer, LocalDateTime>();
    public void reTweet(int tweetId, LocalDateTime localDateTime){
        reTweets.put(tweetId, localDateTime);
    }
    public void undoReTweet(int tweetId){
        reTweets.remove(tweetId);
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Tweet> tweets;

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

package com.emrah.TwitterClone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TWEET")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
    private int tweetId;

    @Column(name = "tweet_body")
    private String tweetBody;

    @Column(name = "tweet_create_date")
    @CreationTimestamp
    private LocalDateTime tweetCreateDate;

    @Column(name = "tweet_update_date")
    @UpdateTimestamp
    private LocalDateTime tweetUpdateDate;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private User user;

}

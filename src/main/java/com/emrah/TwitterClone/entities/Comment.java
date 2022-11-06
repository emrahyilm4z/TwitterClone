package com.emrah.TwitterClone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "comment_body")
    private String commentBody;

    @Column(name = "comment_create_date")
    private LocalDate commentCreateDate;

    @JoinColumn(name = "tweet_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tweet tweet;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}

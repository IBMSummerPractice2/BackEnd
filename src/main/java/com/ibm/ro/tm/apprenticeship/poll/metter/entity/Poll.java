package com.ibm.ro.tm.apprenticeship.poll.metter.entity;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.security.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Poll implements Comparable<Poll>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String question;

    @Column
    @CreationTimestamp
    private LocalDateTime date;



    @OneToMany(targetEntity = Poll.class)
    private List<Vote> pollVotes = new ArrayList<>();


    public Poll( String title, String question) {
        this.title = title;
        this.question = question;
    }

    public Poll() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void addVoteToPoll(Vote vote){
        pollVotes.add(vote);
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", date=" + date
              ;
    }


    @Override
    public int compareTo(Poll o) {
        int result = 0;
        if (o != null) {
            if (id != null) {
                result = id.compareTo(o.getId());
            } else if (o.getId() != null) {
                result = 1;
            } else {
                result = 0;
            }
        } else {
            result = -1;
        }
        return result;
    }
}

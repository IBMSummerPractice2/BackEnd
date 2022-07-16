package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table()
public class Poll implements Comparable<Poll>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String question;
    @Column
    @Transient
    private Timestamp date;


    @JsonIgnore
    @OneToMany(mappedBy = "poll")
    private SortedSet<Vote> votes = new TreeSet<>();

    @ManyToMany(mappedBy = "polls")
    @SortNatural
    @JsonIgnoreProperties("users")
    private SortedSet<User> users = new TreeSet<>();

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

    public Timestamp getDate() {
        return date;
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

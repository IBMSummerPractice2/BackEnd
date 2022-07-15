package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table()
public class Poll implements Comparable<Poll>{

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;


    @Column
    private String title;
    @Column
    private String question;
    @Column
    private Timestamp date;
    // private Long idInitiator;

    @JsonIgnore
    @OneToMany(mappedBy = "poll")
    private SortedSet<Vote> votes = new TreeSet<>();

    public Poll(Long idPoll, String title, String question, Timestamp date) {
        this.ID = idPoll;
        this.title = title;
        this.question = question;
        this.date = date;
    }

    public Poll() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long idPoll) {
        this.ID = idPoll;
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

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Override
    public int compareTo(Poll o) {
        int result = 0;
        if (o != null) {
            if (ID != null) {
                result = ID.compareTo(o.getID());
            } else if (o.getID() != null) {
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

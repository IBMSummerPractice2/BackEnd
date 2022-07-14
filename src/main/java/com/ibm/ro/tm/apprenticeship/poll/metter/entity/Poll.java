package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public class Poll implements Comparable<Poll>{

    @Id
    private Long idPoll;

    @Column
    private String title;
    private String question;
    private Date date;
    // private Long idInitiator;

    public Poll(Long idPoll, String title, String question, Date date) {
        this.idPoll = idPoll;
        this.title = title;
        this.question = question;
        this.date = date;
    }

    public Long getIdPoll() {
        return idPoll;
    }

    public void setIdPoll(Long idPoll) {
        this.idPoll = idPoll;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public int compareTo(Poll o) {
        int result = 0;
        if (o != null) {
            if (idPoll != null) {
                result = idPoll.compareTo(o.getIdPoll());
            } else if (o.getIdPoll() != null) {
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

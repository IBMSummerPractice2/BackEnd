package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Time;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity

public class Vote {
    @Id
    private Long idPoll;
    @Column
    private Integer score;
    @Column
    private String comment;
    @Column
    private Long hashID;
    @Column
    private Timestamp date;

    @JsonIgnore
    @ManyToOne
    private Poll poll;

    public Vote(Long idPoll, Integer score, String comment, Long hashID, Timestamp date) {
        this.idPoll = idPoll;
        this.score = score;
        this.comment = comment;
        this.hashID = hashID;
        this.date = date;
    }

    public Vote() {

    }

    public Long getIdPoll() {
        return idPoll;
    }

    public void setIdPoll(Long idPoll) {
        this.idPoll = idPoll;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getHashID() {
        return hashID;
    }

    public void setHashID(Long hashID) {
        this.hashID = hashID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


}

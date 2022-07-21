package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.sql.Timestamp;


@Entity

public class Vote implements Comparable<Vote>{
    @Id
    private Long idPoll;
    @Column
    private Integer score;
    @Column
    private String comment;
    @Column
    private Long hashID;
    @Column
    //@Transient
    private Timestamp date;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="poll_id",referencedColumnName = "id")
    private Poll poll= new Poll();

    public Poll getPoll() {
        return poll;
    }

    public Vote(Long idPoll, Integer score, String comment, Long hashID) {
        this.idPoll = idPoll;
        this.score = score;
        this.comment = comment;
        this.hashID = hashID;
        this.date = new Timestamp(System.currentTimeMillis());

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


    @Override
    public int compareTo(Vote o) {
        int result;
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

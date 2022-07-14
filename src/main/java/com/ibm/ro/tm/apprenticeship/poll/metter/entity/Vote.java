package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Vote {
    @Id
    private Long idPoll;
    @Column
    private Integer score;
    private String comment;
    private Long hashID;
    private Date date;

    public Vote(Long idPoll, Integer score, String comment, Long hashID, Date date) {
        this.idPoll = idPoll;
        this.score = score;
        this.comment = comment;
        this.hashID = hashID;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

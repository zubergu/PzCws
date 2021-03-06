package com.zubergu.weatherservice.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer cid;

    private String userName;
    private String userComment;

    public Integer getCid() {
	return cid;
    }

    public void setCid(Integer cid) {
	this.cid = cid;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserComment() {
	return userComment;
    }

    public void setUserComment(String userComment) {
	this.userComment = userComment;
    }

}

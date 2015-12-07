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
public class Subscriber {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    
    private String email;
    private String userFirstName;
    private String userLastName;
    
    public Subscriber() {
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getUserFirstName() {
	return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
	this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
	return userLastName;
    }

    public void setUserLastName(String userLastName) {
	this.userLastName = userLastName;
    }

}

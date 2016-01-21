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
public class Administrator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer aid;
    
    private String login;
    private String password;
    
    public Administrator() {
    }


    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
    
    @Override
    public boolean equals(Object o2) {
	Administrator admin2 = (Administrator) o2;
	return password.equals(admin2.password) && login.equals(admin2.login);
    }

}

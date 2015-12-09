package com.zubergu.weatherservice.persistence.entities;

import java.sql.Date;
import java.sql.Time;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransferableDatePeriod {
    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Time endTime;

    public TransferableDatePeriod() {

    }

    public TransferableDatePeriod(Date startDate, Time startTime, Date endDate,
	    Time endTime) {
	this.startDate = startDate;
	this.startTime = startTime;
	this.endDate = endDate;
	this.endTime = endTime;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Time getStartTime() {
	return startTime;
    }

    public void setStartTime(Time startTime) {
	this.startTime = startTime;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public Time getEndTime() {
	return endTime;
    }

    public void setEndTime(Time endTime) {
	this.endTime = endTime;
    }
}

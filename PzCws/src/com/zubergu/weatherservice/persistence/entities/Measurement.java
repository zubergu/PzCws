package com.zubergu.weatherservice.persistence.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Measurement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int measurementId;

    private Date date;
    private Time time;
    private Float temperature;
    private Float humidity;
    private Float odew;
    private Float windchill;
    private Float heatIndex;
    private Float windSpeedMax;
    private Float windSpeedAvg;
    private Integer windDirection;
    private Float pressure;
    private Float pressureSeaLevel;
    private Float rain;
    private Float rainIntensity;
    private Float hail;
    private Float hailIntensity;

    public Measurement() {

    }

    public Measurement(final Date date, 
	    final Time time,
	    final Float temperature,
	    final Float humidity,
	    final Float odew, 
	    final Float windchill,
	    final Float heatIndex, 
	    final Float windSpeedMax,
	    final Float windSpeedAvg,
	    final Integer windDirection,
	    final Float pressure,
	    final Float pressureSeaLevel,
	    final Float rain,
	    final Float rainIntensity,
	    final Float hail,
	    final Float hailIntensity) {
	this.setDate(date);
	this.setTime(time);
	this.setTemperature(temperature);
	this.setHumidity(humidity);
	this.setOdew(odew);
	this.setWindchill(windchill);
	this.setHeatIndex(heatIndex);
	this.setWindSpeedMax(windSpeedMax);
	this.setWindSpeedAvg(windSpeedAvg);
	this.setWindDirection(windDirection);
	this.setPressure(pressure);
	this.setPressureSeaLevel(pressureSeaLevel);
	this.setRain(rain);
	this.setRainIntensity(rainIntensity);
	this.setHail(hail);
	this.setHailIntensity(hailIntensity);
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Time getTime() {
	return time;
    }

    public void setTime(Time time) {
	this.time = time;
    }

    public Float getTemperature() {
	return temperature;
    }

    public void setTemperature(Float temperature) {
	this.temperature = temperature;
    }

    public Float getHumidity() {
	return humidity;
    }

    public void setHumidity(Float humidity) {
	this.humidity = humidity;
    }

    public Float getOdew() {
	return odew;
    }

    public void setOdew(Float odew) {
	this.odew = odew;
    }

    public Float getWindSpeedMax() {
	return windSpeedMax;
    }

    public void setWindSpeedMax(Float windSpeedMax) {
	this.windSpeedMax = windSpeedMax;
    }

    public Integer getWindDirection() {
	return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
	this.windDirection = windDirection;
    }

    public Float getPressure() {
	return pressure;
    }

    public void setPressure(Float pressure) {
	this.pressure = pressure;
    }

    public Float getRain() {
	return rain;
    }

    public void setRain(Float rain) {
	this.rain = rain;
    }

    public Float getHail() {
	return hail;
    }

    public void setHail(Float hail) {
	this.hail = hail;
    }

    public Float getWindchill() {
	return windchill;
    }

    public void setWindchill(Float windchill) {
	this.windchill = windchill;
    }

    public Float getHeatIndex() {
	return heatIndex;
    }

    public void setHeatIndex(Float heatIndex) {
	this.heatIndex = heatIndex;
    }

    public Float getWindSpeedAvg() {
	return windSpeedAvg;
    }

    public void setWindSpeedAvg(Float windSpeedAvg) {
	this.windSpeedAvg = windSpeedAvg;
    }

    public Float getPressureSeaLevel() {
	return pressureSeaLevel;
    }

    public void setPressureSeaLevel(Float pressureSeaLevel) {
	this.pressureSeaLevel = pressureSeaLevel;
    }

    public Float getRainIntensity() {
	return rainIntensity;
    }

    public void setRainIntensity(Float rainIntensity) {
	this.rainIntensity = rainIntensity;
    }

    public Float getHailIntensity() {
	return hailIntensity;
    }

    public void setHailIntensity(Float hailIntensity) {
	this.hailIntensity = hailIntensity;
    }
}

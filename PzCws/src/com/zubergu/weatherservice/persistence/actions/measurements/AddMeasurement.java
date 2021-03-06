package com.zubergu.weatherservice.persistence.actions.measurements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.persistence.entities.Measurement;

public class AddMeasurement {
    
    public void execute() throws IOException {
	URL url = new URL("http://meteo.ftj.agh.edu.pl/meteo/meteo.xml");
	URLConnection conn = url.openConnection();

	BufferedReader in = new BufferedReader(new InputStreamReader(
		conn.getInputStream()));
	String result = "";
	String line = "";
	while ((line = in.readLine()) != null) {
	    result += line + "\n";
	}
	System.out.println(result);

	String el = result;

	Measurement measurement = new Measurement();

	String dateString = getDateFromResult(el);
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
		Locale.ENGLISH);
	java.util.Date dateUtil = null;
	try {
	    dateUtil = format.parse(dateString);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	measurement.setDate(new Date(dateUtil.getTime()));
	measurement.setTime(new Time(dateUtil.getTime()));
	measurement.setTemperature(Float.parseFloat(readFromXml(el, "ta")));
	measurement.setHumidity(Float.parseFloat(readFromXml(el, "ua")));
	measurement.setOdew(Float.parseFloat(readFromXml(el, "odew")));
	measurement.setWindchill(Float
		.parseFloat(readFromXml(el, "owindchill")));
	try {
	    measurement.setHeatIndex(Float.parseFloat(readFromXml(el, "ua")));
	} catch (NumberFormatException nfe) {
	    measurement.setHeatIndex(null);
	}
	measurement.setWindSpeedMax(Float.parseFloat(readFromXml(el, "sx")));
	measurement.setWindSpeedAvg(Float.parseFloat(readFromXml(el, "sm")));
	measurement.setWindDirection(Integer.parseInt(readFromXml(el, "dm")));
	measurement.setPressure(Float.parseFloat(readFromXml(el, "pa")));
	measurement.setPressureSeaLevel(Float.parseFloat(readFromXml(el,
		"barosealevel")));
	measurement.setRain(Float.parseFloat(readFromXml(el, "rc")));
	measurement.setRainIntensity(Float.parseFloat(readFromXml(el, "hc")));
	measurement.setHail(Float.parseFloat(readFromXml(el, "ri")));
	measurement.setHailIntensity(Float.parseFloat(readFromXml(el, "hi")));
	
	
	
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(measurement);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }
    
    /*
     * parsing methods will be removed after moving save to 
     */
    private String readFromXml(String element, String tag) {
	String regex = "<" + tag + ">\\.*(-?\\d+\\.?\\d*).*</" + tag + ">";
	Pattern pattern = Pattern.compile(regex);
	Matcher mt = pattern.matcher(element);

	mt.find();

	return mt.group(1);
    }

    private String getDateFromResult(String result) {
	Pattern pattern = Pattern.compile("data=\"(.*)>");
	Matcher matcher = pattern.matcher(result);

	if (matcher.find()) {
	    return matcher.group(1);
	}

	return "";

    }
}

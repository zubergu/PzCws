package com.zubergu.weatherservice.other.tests;

import java.sql.Date;
import java.util.List;

import com.zubergu.weatherservice.persistence.actions.measurements.RetrieveMeasurement;
import com.zubergu.weatherservice.persistence.entities.Measurement;

public class RetrieveMeasurementByDateTest {
    public static void main(String[] args) {
	RetrieveMeasurement rm = new RetrieveMeasurement();
		
	java.util.Date dateUtil = new java.util.Date();
	java.sql.Date date = new Date(dateUtil.getTime());
	System.out.println(dateUtil.toString());
	List<Measurement> meas = rm.retrieveForDay(date);

	System.out.println(meas.size());
    }
}

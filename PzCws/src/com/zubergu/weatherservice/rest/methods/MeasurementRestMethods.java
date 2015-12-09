package com.zubergu.weatherservice.rest.methods;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.zubergu.weatherservice.persistence.actions.measurements.AddMeasurement;
import com.zubergu.weatherservice.persistence.actions.measurements.RetrieveMeasurement;
import com.zubergu.weatherservice.persistence.entities.Measurement;
import com.zubergu.weatherservice.persistence.entities.TransferableDatePeriod;

@Path("measurements")
public class MeasurementRestMethods {

    @Path("save")
    @GET
    public void saveNewMeasurementInDatabase() throws IOException,
	    ParserConfigurationException, SAXException {
	new AddMeasurement().execute();

    }

    @Path("latest")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Measurement retrieveLatestMeasurement() {
	return new RetrieveMeasurement().retrieveLatest();
    }

    @Path("date")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Measurement> retrieveMeasurementForDate(Date date) {
	return new RetrieveMeasurement().retrieveForDay(date);
    }

    @Path("period")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Measurement> retrieveMeasurementForPeriod(
	    TransferableDatePeriod period) {
	return new RetrieveMeasurement().retrieveForPeriod(
		period.getStartDate(), period.getStartTime(),
		period.getEndDate(), period.getEndTime());
    }

    @Path("average/temperature/date")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getAverageTemperatureDate(Date date) {
	return new RetrieveMeasurement().averageTemperatureForDay(date);
    }

    @Path("average/temperature/period")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getAverageTemperaturePeriod(TransferableDatePeriod period) {
	return new RetrieveMeasurement().averageTemperatureForPeriod(
		period.getStartDate(), period.getStartTime(),
		period.getEndDate(), period.getEndTime());
    }

}

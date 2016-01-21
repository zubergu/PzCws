package com.zubergu.weatherservice.rest.methods;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.zubergu.weatherservice.persistence.actions.measurements.AddMeasurement;
import com.zubergu.weatherservice.persistence.actions.measurements.RetrieveMeasurement;
import com.zubergu.weatherservice.persistence.entities.Measurement;

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
    public List<Measurement> retrieveMeasurementForDate (@QueryParam("date") Date date) {
	return new RetrieveMeasurement().retrieveForDay(date);
    }

    @Path("period")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Measurement> retrieveMeasurementForPeriod(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
	return new RetrieveMeasurement().retrieveForPeriod(startDate, endDate);
    }

    @Path("average/temperature/date")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getAverageTemperatureDate(@QueryParam("date")Date date) {
	return new RetrieveMeasurement().averageTemperatureForDay(date);
    }
    
    @Path("min/temperature/date")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getMinTemperatureDate(@QueryParam("date")Date date) {
	return new RetrieveMeasurement().minTemperatureForDay(date);
    }
    
    @Path("max/temperature/date")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getMaxTemperatureDate(@QueryParam("date")Date date) {
	return new RetrieveMeasurement().maxTemperatureForDay(date);
    }

    @Path("average/temperature/period")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getAverageTemperaturePeriod(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
	return new RetrieveMeasurement().averageTemperatureForPeriod(startDate, endDate);
    }
    
    @Path("min/temperature/period")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getMinTemperaturePeriod(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
	return new RetrieveMeasurement().minTemperatureForPeriod(startDate, endDate);
    }
    
    
    @Path("max/temperature/period")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Float getMaxTemperaturePeriod(@QueryParam("startDate") Date startDate, @QueryParam("endDate") Date endDate) {
	return new RetrieveMeasurement().maxTemperatureForPeriod(startDate, endDate);
    }

}

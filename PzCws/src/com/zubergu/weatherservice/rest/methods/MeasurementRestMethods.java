package com.zubergu.weatherservice.rest.methods;

import java.io.IOException;
import java.sql.Date;
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

@Path("measurements")
public class MeasurementRestMethods {

    @Path("save")
    @GET
    public void saveNewMeasurementInDatabase() throws IOException,
	    ParserConfigurationException, SAXException {
	AddMeasurement addMeasurement = new AddMeasurement();
	addMeasurement.execute();

    }

    @Path("latest")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Measurement retrieveLatestMeasurement() {
	RetrieveMeasurement measurements = new RetrieveMeasurement();
	return measurements.retrieveLatest();
    }

    @Path("date")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Measurement> retrieveMeasurementForDate(Date date) {
	RetrieveMeasurement rm = new RetrieveMeasurement();
	return rm.retrieveForDay(date);
    }

}

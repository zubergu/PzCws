package com.zubergu.weatherservice.rest.methods;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.zubergu.weatherservice.persistence.actions.administrators.AddAdministrator;
import com.zubergu.weatherservice.persistence.entities.Administrator;

@Path("administration")
public class AdminRestMethods {

    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void saveNewAdmin(@FormParam("login") String login,
	    @FormParam("password") String password) throws IOException,
	    ParserConfigurationException, SAXException {
	Administrator newAdmin = new Administrator();
	newAdmin.setLogin(login);
	newAdmin.setPassword(password);
	new AddAdministrator().execute(newAdmin);

    }

}

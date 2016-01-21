package com.zubergu.weatherservice.other.listeners;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MeasurementRefreshListener implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
	ServletContext context = event.getServletContext();
	
	scheduler = Executors.newSingleThreadScheduledExecutor();
	
	context.setAttribute("scheduler", scheduler);
	
	Runnable r = new Runnable() {
	        @Override
	        public void run() {
	            try {
	        	URL url = new URL("http://localhost:8080/PzCws/measurements/save");
	        	   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        	   connection.setRequestMethod("GET");
	        	   connection.getResponseCode();
	        	   System.out.println("Connecting to save measurement");
		    } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
	        }
	    };
	    
        scheduler.scheduleAtFixedRate(r, 0, 1, TimeUnit.MINUTES);
        
        System.out.println("Context listener loaded");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}
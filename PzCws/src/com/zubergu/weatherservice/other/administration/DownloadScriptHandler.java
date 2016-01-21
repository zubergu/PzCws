package com.zubergu.weatherservice.other.administration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadScriptHandler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	String wantedState = request.getParameter("wantedState");
	boolean wantToBeRunning = wantedState.equalsIgnoreCase("run");

	ServletContext context = getServletContext();
	ScheduledExecutorService scheduler = (ScheduledExecutorService) context
		.getAttribute("scheduler");
	boolean schedulerRunning = !scheduler.isShutdown();
	if (wantToBeRunning && !schedulerRunning) {
	    Runnable r = new Runnable() {
		@Override
		public void run() {
		    try {
			URL url = new URL(
				"http://localhost:8080/PzCws/measurements/save");
			HttpURLConnection connection = (HttpURLConnection) url
				.openConnection();
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
	    System.out.println("Trying to start");
	    scheduler = Executors.newSingleThreadScheduledExecutor();

	    context.setAttribute("scheduler", scheduler);

	    scheduler.scheduleAtFixedRate(r, 0, 1, TimeUnit.MINUTES);
	    request.setAttribute("schedulerState", !((ScheduledExecutorService)context.getAttribute("scheduler")).isShutdown());
	} else if (!wantToBeRunning && schedulerRunning) {
	    System.out.println("Trying to stop");
	    scheduler.shutdownNow();
	    request.setAttribute("schedulerState", !((ScheduledExecutorService)context.getAttribute("scheduler")).isShutdown());
	}
	
	RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
	rd.forward(request, response);

    }

}

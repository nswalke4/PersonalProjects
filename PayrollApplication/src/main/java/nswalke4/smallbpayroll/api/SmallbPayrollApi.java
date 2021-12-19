package main.java.nswalke4.smallbpayroll.api;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * This class is the Smallb Payroll REST API which allows the front end to
 * execute commands on the back end of the Smallb Payroll Application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class SmallbPayrollApi extends HttpServlet {
	
	// Class Variables
	private static final long serialVersionUID = -7174927741311355125L;
	private final String JSON_CONTENT = "application/json";

	/**
	 * Initializes the Smallb Payroll Servlet to be able to accept http methods.
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/**
	 * Handles all of the requests that come in via a "get" request.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(JSON_CONTENT);
		JSONObject requestObj = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		String command = requestObj.getString("command");
		JSONObject responseObj = new JSONObject();
		switch (command) {
			default:
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseObj.put("message", "Given get-command is not available.");
				break;
		}
		response.getWriter().println(responseObj.toString());
	}

	/**
	 * Handles all of the requests that come in via a "post" request.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(JSON_CONTENT);
		JSONObject requestObj = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		String command = requestObj.getString("command");
		JSONObject responseObj = new JSONObject();
		switch (command) {
			default:
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseObj.put("message", "Given post-command is not available.");
				break;
		}
		response.getWriter().println(responseObj.toString());
	}

	/**
	 * Handles all of the requests that come in via a "delete" request.
	 */
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(JSON_CONTENT);
		JSONObject requestObj = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		String command = requestObj.getString("command");
		JSONObject responseObj = new JSONObject();
		switch (command) {
			default:
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseObj.put("message", "Given delete-command is not available.");
				break;
		}
		response.getWriter().println(responseObj.toString());
	}
}
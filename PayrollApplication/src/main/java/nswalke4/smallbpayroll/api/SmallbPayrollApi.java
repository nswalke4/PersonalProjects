package nswalke4.smallbpayroll.api;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * This class is the Smallb Payroll REST API which allows the front end to execute commands on the
 * back end of the Smallb Payroll Application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(JSON_CONTENT);
		JSONObject responseObj = new JSONObject();
		try {
			if (!request.getContentType().equals(JSON_CONTENT)) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseObj.put("Failure", "Invalid Content Type");
				responseObj.put("ErrorMessage",
						"The content type of the request cannot be properly "
								+ "handled.  Currently, this server can only accept \""
								+ JSON_CONTENT + "\"" + " as the request content-type.");
			} else {
				JSONObject requestObj =
						new JSONObject(request.getReader().lines().collect(Collectors.joining()));
				if (!requestObj.has("Method")) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					responseObj.put("Failure", "Invalid Parameters");
					responseObj.put("ErrorMessage",
							"The \"Method\" parameter is required in order to "
									+ "properly execute the requested command.");
				} else {
					String method = requestObj.getString("Method");
					switch (method) {

						case "GetAccountInfo":
							if (requestObj.has("AccountSub")) {
								responseObj = SmallbPayrollMethods.gatherAccountInformation(
										requestObj.getString("AccountSub"));
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_OK);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"Value for \"AccountSub\" was not found and is"
												+ " a required parameter for this method");
							}
							break;

						case "GetEmployeeTimecards":
							if (requestObj.has("EmployeeId")) {
								responseObj = SmallbPayrollMethods.gatherEmployeeTimecards(
										requestObj.getString("EmployeeId"));
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_OK);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"Value for \"EmployeeId\" was not found and is"
												+ " a required parameter for this method");
							}
							break;

						case "GetPayPeriodTimecards":
							if (requestObj.has("PayPeriodId")) {
								responseObj = SmallbPayrollMethods.gatherPayPeriodTimecards(
										requestObj.getString("PayPeriodId"));
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_OK);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"Value for \"PayPeriodId\" was not found and is"
												+ " a required parameter for this method");
							}
							break;

						default:
							response.setStatus(HttpServletResponse.SC_NOT_FOUND);
							responseObj.put("Failure", "Method Not Found");
							responseObj.put("ErrorMessage",
									"The client's requested \"get\" method was not "
											+ "found as a valid method on this server.");
							break;

					}
				}

			}
		} catch (NullPointerException npe) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			responseObj.put("Failure", "No Content");
			responseObj.put("ErrorMessage",
					"The request that was made to the server contained no content in either the header or in the body.  Requests to this servlet must contain a \"content-type\" header, and the body must contain a \"Method\" parameter, plus any additional parameters that are necessary for the requested method.");
		}

		response.getWriter().println(responseObj.toString());
	}

	/**
	 * Handles all of the requests that come in via a "post" request.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(JSON_CONTENT);
		JSONObject responseObj = new JSONObject();
		if (!request.getContentType().equals(JSON_CONTENT)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			responseObj.put("Failure", "Invalid Content Type");
			responseObj.put("ErrorMessage",
					"The content type of the request cannot be properly "
							+ "handled.  Currently, this server can only accept \"" + JSON_CONTENT
							+ "\"" + " as the request content-type.");
		} else {
			JSONObject requestObj =
					new JSONObject(request.getReader().lines().collect(Collectors.joining()));
			if (!requestObj.has("Method")) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				responseObj.put("Failure", "Invalid Parameters");
				responseObj.put("ErrorMessage", "The \"Method\" parameter is required in order to "
						+ "properly execute the requested command.");
			} else {
				String method = requestObj.getString("Method");
				switch (method) {

					case "CreateNewAccount":
						if (requestObj.has("NewAccount")) {
							JSONObject newAccountObj = requestObj.getJSONObject("NewAccount");
							if ((newAccountObj.has("AccountSub")) && (newAccountObj.has("Name"))
									&& (newAccountObj.has("Email"))
									&& (newAccountObj.has("PayPeriodType"))) {
								responseObj = SmallbPayrollMethods.createNewAccount(newAccountObj);
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_CREATED);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"The \"NewAccount\" object must have the "
												+ "following parameters: AccountSub, Name, Email, PayPeriodType");
							}
						} else {
							response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							responseObj.put("Failure", "Invalid Parameters");
							responseObj.put("ErrorMessage",
									"Object for \"NewAccount\" was not found and "
											+ "is a required parameter for this method");
						}
						break;

					case "CreateNewEmployee":
						if ((requestObj.has("AccountSub")) && (requestObj.has("NewEmployee"))) {
							JSONObject newEmployeeObj = requestObj.getJSONObject("NewEmployee");
							if ((newEmployeeObj.has("EmployeeId"))
									&& (newEmployeeObj.has("FirstName"))
									&& (newEmployeeObj.has("LastName"))
									&& (newEmployeeObj.has("EmpType"))
									&& (newEmployeeObj.has("PayRate"))) {
								responseObj = SmallbPayrollMethods.createNewEmployee(requestObj);
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_CREATED);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"The \"NewEmployee\" object must have the "
												+ "following parameters: EmployeeId, FirstName, LastName, EmpType,"
												+ " PayRate");
							}
						} else {
							response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							responseObj.put("Failure", "Invalid Parameters");
							responseObj.put("ErrorMessage",
									"The creation of a \"NewEmployee\" must "
											+ "include both the \"NewEmployee\" object as well as the "
											+ "\"AccountSub\" that the employee belongs to.");

						}
						break;

					case "CreateNewPayPeriod":
						if ((requestObj.has("AccountSub")) && (requestObj.has("PeriodStartDate"))) {
							responseObj = SmallbPayrollMethods.createNewPayPeriod(requestObj);
							if (responseObj.has("Failure")) {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							} else {
								response.setStatus(HttpServletResponse.SC_CREATED);
							}
						} else {
							response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							responseObj.put("Failure", "Invalid Parameters");
							responseObj.put("ErrorMessage",
									"The creation of a \"NewPayPeriod\" must "
											+ "include both the \"PeriodStartDate\" as well as the "
											+ "\"AccountSub\" that the pay period belongs to.");

						}
						break;

					case "CreateNewTimecard":
						if ((requestObj.has("AccountSub")) && (requestObj.has("TimecardInfo"))) {
							JSONObject timecardObj = requestObj.getJSONObject("TimecardInfo");
							if ((timecardObj.has("EmployeeId")) && (timecardObj.has("PeriodId"))) {
								responseObj = SmallbPayrollMethods.createNewTimecard(requestObj);
								if (responseObj.has("Failure")) {
									response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								} else {
									response.setStatus(HttpServletResponse.SC_CREATED);
								}
							} else {
								response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
								responseObj.put("Failure", "Invalid Parameters");
								responseObj.put("ErrorMessage",
										"The \"TimecardInfo\" object must have "
												+ "the following parameters: EmployeeId, PeriodId");
							}
						} else {
							response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							responseObj.put("Failure", "Invalid Parameters");
							responseObj.put("ErrorMessage",
									"The creation of a \"NewEmployeeTimecard\" "
											+ "must include both the \"TimecardInfo\" as well as the "
											+ "\"AccountSub\" that the timecard belongs to.");
						}
						break;

					default:
						response.setStatus(HttpServletResponse.SC_NOT_FOUND);
						responseObj.put("Failure", "Method Not Found");
						responseObj.put("ErrorMessage",
								"The client's requested \"post\" method was not "
										+ "found as a valid method on this server.");
						break;
				}
			}
		}
		response.getWriter().println(responseObj.toString());
	}

	// /**
	// * Handles all of the requests that come in via a "delete" request.
	// */
	// public void doDelete(HttpServletRequest request, HttpServletResponse response) throws
	// ServletException, IOException {
	// response.setContentType(JSON_CONTENT);
	// JSONObject responseObj = new JSONObject();
	// if (!request.getContentType().equals(JSON_CONTENT)) {
	// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	// responseObj.put("Failure", "Invalid Content Type");
	// responseObj.put("ErrorMessage", "The content type of the request cannot be properly "
	// + "handled. Currently, this server can only accept \"" + JSON_CONTENT + "\""
	// + " as the request content-type.");
	// }
	// JSONObject requestObj = new JSONObject(request.getReader().lines()
	// .collect(Collectors.joining()));
	// String method = requestObj.getString("Method");
	// switch (method) {
	// default:
	// response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	// responseObj.put("Failure", "Command Not Found");
	// responseObj.put("ErrorMessage", "The client's requested \"delete\" method was not "
	// + "found as a valid method on this server.");
	// break;
	// }
	// response.getWriter().println(responseObj.toString());
	// }
}

package com.swagger.utils;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

public class PrintLog {
	private static Logger logInstance = LogManager.getLogger();

	/**
	 * Prints the API response.
	 *
	 * @param resp - Response
	 */
	public void printResponse(Response resp) {

		if (resp.getBody() != null) {
			logInstance.info("Headers :: [{}]", resp.getHeaders());
			logInstance.info("Cookies :: [{}]", resp.getCookies());
			logInstance.info("Status Code :: [{}]", resp.getStatusCode());
			logInstance.info("Status Line :: [{}]", resp.getStatusLine());
			logInstance.info("Session ID :: [{}]", resp.getSessionId());
			logInstance.info("Response Time :: [{}] milliseconds", resp.getTimeIn(TimeUnit.MILLISECONDS));
			logInstance.info("Response :: [{}]", resp.asString());
		} else {
			logInstance.error("No response body found");
		}
	}
}

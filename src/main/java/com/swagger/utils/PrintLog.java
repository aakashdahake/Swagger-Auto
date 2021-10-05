package com.swagger.utils;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

public class PrintLog {
	
	private String baseUrl = ConfigManager.getInstance().getString("base_url");
	private static Logger logger = LogManager.getLogger();

	/**
	 * Prints the API response.
	 *
	 * @param resp - Response
	 */
	public void printResponse(Response resp, String uri, String message) {

		if (resp.getBody() != null) {
			logger.info("Endpoint :: [{}]", baseUrl + uri);
			logger.info("Headers :: [{}]", resp.getHeaders());
			logger.info("Cookies :: [{}]", resp.getCookies());
			logger.info("Status Code :: [{}]", resp.getStatusCode());
			logger.info("Status Line :: [{}]", resp.getStatusLine());
			logger.info("Session ID :: [{}]", resp.getSessionId());
			logger.info("Response Time :: [{}] milliseconds", resp.getTimeIn(TimeUnit.MILLISECONDS));
			logger.info("Response :: [{}]", resp.asString());
			logger.info(message);
		} else {
			logger.error("No response body found");
		}
	}
}

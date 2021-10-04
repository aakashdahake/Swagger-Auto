package com.swagger.libraries;

import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.UserData;
import com.swagger.constants.Endpoints;
import com.swagger.utils.PrintLog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User {

	private Logger logger = LogManager.getLogger();
	private JsonParser parser = JsonParser.DEFAULT;
	private PrintLog printResponse = new PrintLog();
	
	private final String baseUrl = "http://localhost:8080/api/v3/";
	
	public User() {
		RestAssured.baseURI = baseUrl;
	}
	
	/**
	 * Creates the user.
	 *
	 * @param userData the user data
	 * @param url the url
	 * @return the user data
	 */
	public UserData createUser(UserData userData) {

		UserData responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(userData)
					.when()
					.post(Endpoints.CREATE_USER.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), UserData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	
	/**
	 * Creates the users with list.
	 *
	 * @param userDataList the user data list
	 * @param url the url
	 * @return the user data[]
	 */
	public UserData[] createUsersWithList(UserData[] userDataList) {

		UserData[] responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(userDataList)
					.when()
					.post(Endpoints.CREATE_USER_LIST.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), UserData[].class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Gets the user login.
	 *
	 * @param username the username
	 * @param passwd the passwd
	 * @param url the url
	 * @return the user login
	 */
	public String getUserLogin(String username, String passwd) {

		String responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("username", username)
					.queryParam("password", passwd)
					.when()
					.get(Endpoints.GET_LOGIN.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);
			
			responseData = resp.asString();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	/**
	 * Gets the user logsout.
	 *
	 * @param url the url
	 * @return the user logsout
	 */
	public String getUserLogsout() {

		String responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get(Endpoints.GET_LOGOUT.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);
			
			responseData = resp.asString();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Gets the user by username.
	 *
	 * @param username the username
	 * @param url the url
	 * @return the userData by username
	 */
	public UserData getUserByUsername(String username) {

		UserData responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("username", username)
					.when()
					.get(Endpoints.OPERATE_USER.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);
			
			responseData = parser.parse(resp.asString(), UserData.class);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	/**
	 * Update user by username.
	 *
	 * @param username the username
	 * @param url the url
	 * @return the updated user data
	 */
	public UserData updateUserByUsername(String username) {

		UserData responseData = null;

		try {
			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.queryParam("username", username)
					.when()
					.put(Endpoints.OPERATE_USER.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), UserData.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	/**
	 * Delete user by username.
	 *
	 * @param username the username
	 * @param url the url
	 */
	public void deleteUserByUsername(String username) {

		try {

				RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", username)
					.when()
					.delete(Endpoints.OPERATE_USER.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			logger.info("Deleted User Successfully with Username :: [{}]", username);

		} catch (AssertionError e) {
			logger.error(e.getMessage());
		}
	}
	
	
	
}

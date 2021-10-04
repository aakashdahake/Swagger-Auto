package com.swagger.libraries;

import org.apache.http.HttpStatus;
import org.apache.juneau.json.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.GetInventory;
import com.swagger.POJOs.PlaceOrderInStore;
import com.swagger.constants.Endpoints;
import com.swagger.utils.PrintLog;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Store {
	
	private Logger logger = LogManager.getLogger();
	private JsonParser parser = JsonParser.DEFAULT;
	private PrintLog printResponse = new PrintLog();
	
	private final String baseUrl = "http://localhost:8080/api/v3/";
	
	public Store() {
		RestAssured.baseURI = baseUrl;
	}
	
	/**
	 * Gets the store inventory.
	 *
	 * @param url the url
	 * @return the store inventory
	 */
	public GetInventory getStoreInventory() {

		GetInventory responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.when()
					.get(Endpoints.GET_STORE_INVENTORY.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), GetInventory.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	/**
	 * Gets the store inventory.
	 *
	 * @param orderData the order data
	 * @param url the url
	 * @return the store inventory
	 */
	public PlaceOrderInStore getStoreInventory(PlaceOrderInStore orderData) {

		PlaceOrderInStore responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(orderData)
					.when()
					.post(Endpoints.ADD_ORDER.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), PlaceOrderInStore.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Gets the order by id.
	 *
	 * @param orderId the order id
	 * @param url the url
	 * @return the order by id
	 */
	public GetInventory getOrderById(int orderId) {

		GetInventory responseData = null;

		try {

			Response resp = RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("orderId", orderId)
					.when()
					.get(Endpoints.GET_ORDER_BY_ID.getConstant())
					.then().assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			printResponse.printResponse(resp);

			responseData = parser.parse(resp.asString(), GetInventory.class);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return responseData;
	}
	
	
	/**
	 * Delete order by id.
	 *
	 * @param orderId the order id
	 * @param url the url
	 */
	public void deleteOrderById(int orderId) {

		try {

				RestAssured.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("orderId", orderId)
					.when()
					.delete(Endpoints.DELETE_ORDER.getConstant())
					.then()
					.assertThat().statusCode(HttpStatus.SC_OK)
					.and()
					.extract().response();

			logger.info("Deleted Order Successfully with Order ID :: [{}]", orderId);

		} catch (AssertionError e) {
			logger.error(e.getMessage());
		}
	}
	
}

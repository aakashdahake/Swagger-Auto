package com.swagger.POJOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "petId", "quantity", "shipDate", "status", "complete" })

public class PlaceOrderInStore {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("petId")
	private Integer petId;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("shipDate")
	private String shipDate;
	@JsonProperty("status")
	private String status;
	@JsonProperty("complete")
	private Boolean complete;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("petId")
	public Integer getPetId() {
		return petId;
	}

	@JsonProperty("petId")
	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("shipDate")
	public String getShipDate() {
		return shipDate;
	}

	@JsonProperty("shipDate")
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("complete")
	public Boolean getComplete() {
		return complete;
	}

	@JsonProperty("complete")
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PlaceOrderInStore.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("petId");
		sb.append('=');
		sb.append(((this.petId == null) ? "<null>" : this.petId));
		sb.append(',');
		sb.append("quantity");
		sb.append('=');
		sb.append(((this.quantity == null) ? "<null>" : this.quantity));
		sb.append(',');
		sb.append("shipDate");
		sb.append('=');
		sb.append(((this.shipDate == null) ? "<null>" : this.shipDate));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null) ? "<null>" : this.status));
		sb.append(',');
		sb.append("complete");
		sb.append('=');
		sb.append(((this.complete == null) ? "<null>" : this.complete));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
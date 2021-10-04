package com.swagger.POJOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "approved", "placed", "delivered" })

public class GetInventory {

	@JsonProperty("approved")
	private Integer approved;
	@JsonProperty("placed")
	private Integer placed;
	@JsonProperty("delivered")
	private Integer delivered;

	@JsonProperty("approved")
	public Integer getApproved() {
		return approved;
	}

	@JsonProperty("approved")
	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	@JsonProperty("placed")
	public Integer getPlaced() {
		return placed;
	}

	@JsonProperty("placed")
	public void setPlaced(Integer placed) {
		this.placed = placed;
	}

	@JsonProperty("delivered")
	public Integer getDelivered() {
		return delivered;
	}

	@JsonProperty("delivered")
	public void setDelivered(Integer delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(GetInventory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("approved");
		sb.append('=');
		sb.append(((this.approved == null) ? "<null>" : this.approved));
		sb.append(',');
		sb.append("placed");
		sb.append('=');
		sb.append(((this.placed == null) ? "<null>" : this.placed));
		sb.append(',');
		sb.append("delivered");
		sb.append('=');
		sb.append(((this.delivered == null) ? "<null>" : this.delivered));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
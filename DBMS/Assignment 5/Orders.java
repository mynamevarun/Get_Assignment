package jdbc;

import java.util.*;

/* This class consists of getters and setters.
 *
 */
public class Orders {

	// Instance variables.
	private int orderId;
	private Date Date;
	private int order_total;

	// Getters and setters.
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getOrder_total() {
		return order_total;
	}

	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
}

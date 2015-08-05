package com.erhsh.prj.distrmgmtsys.model;

// Generated 2015-8-5 23:30:11 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderHeader generated by hbm2java
 */
@Entity
@Table(name = "order_header", catalog = "distrmgmtsys")
public class OrderHeader implements java.io.Serializable {

	private long orderId;
	private String orderName;
	private Date orderDate;
	private Integer orderStatusId;

	public OrderHeader() {
	}

	public OrderHeader(long orderId) {
		this.orderId = orderId;
	}

	public OrderHeader(long orderId, String orderName, Date orderDate,
			Integer orderStatusId) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.orderStatusId = orderStatusId;
	}

	@Id
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "ORDER_NAME")
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_DATE", length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "ORDER_STATUS_ID")
	public Integer getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

}

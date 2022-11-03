package com.springboot.order.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foods")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderid;
	@Column(name="order_name")
	private String order_name;
	@Column(name="waiter_id")
	private Long waiterid;
	@Column(name="quantities")
	private int quantities;
	@Column(name="start_time")
	private LocalDateTime startTime=LocalDateTime.now();
	@Column(name="end_time")
	private LocalDateTime endTime=LocalDateTime.now();
	public Order() {
		super();
		
	}
	public Order(Long orderid, String order_name, Long waiterid, int quantities, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.orderid = orderid;
		this.order_name = order_name;
		this.waiterid = waiterid;
		this.quantities = quantities;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public Long getWaiterid() {
		return waiterid;
	}
	public void setWaiterid(Long waiterid) {
		this.waiterid = waiterid;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}

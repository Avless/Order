package com.springboot.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.order.exception.ResourceNotFoundException;
import com.springboot.order.model.Order;
import com.springboot.order.repository.OrderRepository;

@RestController
@RequestMapping("/restaurants")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	@GetMapping("/orders")
	public List<Order>getAllOrder(){
		return orderRepository.findAll();
	}
	@PostMapping("/orders")
	public Order createOrder(@Validated @RequestBody Order order) {
		return orderRepository.save(order);
	}
	 @PutMapping("/order/{orderid}")
	    public ResponseEntity<Order>
	    updateOrder(@PathVariable(value="orderid") Long orderId,@Validated @RequestBody Order orderDetails){
	        Order order=orderRepository.findById(orderId)
	                .orElseThrow(()-> new ResourceNotFoundException("Raw Material Order not found fo this id: "
	                        +orderId));
	        order.setOrderid(orderDetails.getOrderid());
	        order.setOrder_name(orderDetails.getOrder_name());
	        order.setStartTime(orderDetails.getStartTime());
	        order.setEndTime(orderDetails.getEndTime());        
	        Order updateOrder = orderRepository.save(order);
	        return ResponseEntity.ok(updateOrder);
	    } 
	 @DeleteMapping("/order/{orderId}")
	    public Map<String,Boolean> deleteOrder(@PathVariable(value="orderId") Long orderId)
	            throws ResourceNotFoundException{
	        Order order=orderRepository.findById(orderId)
	                .orElseThrow(() -> new ResourceNotFoundException("Raw Material Order not found fo this id: "
	        +orderId));
	        orderRepository.delete(order);
	        Map<String, Boolean> response =new HashMap<>();
	        response.put("deleted",Boolean.TRUE);
	        return response;
	}}



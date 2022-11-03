package com.springboot.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.order.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}

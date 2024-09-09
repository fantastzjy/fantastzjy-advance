package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private OrderService orderService;

	public void test() {
		System.out.println(orderService);
	}


}

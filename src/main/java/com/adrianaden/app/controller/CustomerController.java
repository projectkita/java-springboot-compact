package com.adrianaden.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.adrianaden.app.model.Customer;
import com.adrianaden.app.response.ResponseBody;
import com.adrianaden.app.response.ResponseCode;
import com.adrianaden.app.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = { RequestMethod.GET })
	public ResponseEntity<ResponseBody> findAll() {
		List<Customer> customers = customerService.findAll();
		ResponseBody body = new ResponseBody(ResponseCode.SUCCESS, "Success get Customer", customers);
		return ResponseEntity.ok().body(body);
	}
}

package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Policy;
import com.service.ClientService;



@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/loadpolicies")
	public ResponseEntity<List<Policy>> loadAllPolicies() {
		return ResponseEntity.ok(service.loadAllPolicies());
	}
	@PostMapping("/addpolicy")
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {

		Policy savedData = service.createPolicy(policy);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedData);

	}

	@GetMapping("/loadpolicy/{pid}")
	public ResponseEntity<Policy> loadPolicy(@PathVariable int pid) {
		return ResponseEntity.ok(service.getPolicyById(pid));
	}



}

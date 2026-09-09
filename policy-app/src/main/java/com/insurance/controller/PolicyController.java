package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Policy;
import com.insurance.model.PolicyStatus;
import com.insurance.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	@Autowired
	private PolicyService policyService;

	@PostMapping("/add")
	public ResponseEntity<Policy> createPolicy(@Valid @RequestBody Policy policy) {

		Policy savedData = policyService.createPolicy(policy);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedData);

	}

	@GetMapping("/loadall")
	public ResponseEntity<List<Policy>> loadAllPolicies() {
		return ResponseEntity.ok(policyService.loadPolicies());
	}

	@GetMapping("/loadpolicy/{pid}")
	public ResponseEntity<Policy> loadPolicie(@PathVariable int pid) {
		return ResponseEntity.ok(policyService.getPolicyByID(pid));
	}

	@DeleteMapping("/deletepolicy/{pid}")
	public ResponseEntity<String> delete(@PathVariable int pid) {
		policyService.deletePolicy(pid);
		return ResponseEntity.ok("POlicy deleted");
	}
	@PutMapping("/updatepolicy/{pid}")
	public ResponseEntity<Policy> update(@PathVariable int pid,@RequestBody Policy policy) {
		
		return ResponseEntity.ok(policyService.updatePolicy(pid,policy) );
	}
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Policy>> getstatus(@PathVariable PolicyStatus status) {
	
		return ResponseEntity.ok(policyService.loadPoliciesByStatus(status));
	}

}

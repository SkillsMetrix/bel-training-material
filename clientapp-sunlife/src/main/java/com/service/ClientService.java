package com.service;

 import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.Policy;

@Service
public class ClientService {
	@Autowired
	private RestTemplate restTemplate;
	
	private final String POLICY_SERVICE_URL="http://policy-app/policy";

	 public List<Policy>loadAllPolicies(){
		 Policy[] policies= restTemplate.getForObject(POLICY_SERVICE_URL +"/loadall", Policy[].class);
		 return Arrays.asList(policies);
	 }
	
	 public Policy createPolicy(Policy policy) {
		 return restTemplate.postForObject(POLICY_SERVICE_URL +"/add", policy, Policy.class);
	 }
	 public Policy getPolicyById(int pid) {
		 return restTemplate.getForObject(POLICY_SERVICE_URL+"/loadpolicy/" +pid, Policy.class);
	 }

}

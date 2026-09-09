package com.insurance.dao;

import java.util.List;

import com.insurance.model.Policy;
import com.insurance.model.PolicyStatus;

public interface PolicyDAO {
	public Policy createPolicy(Policy policy);
	public List<Policy> loadPolicies();
	public Policy getPolicyByID(int pid);
	public void deletePolicy(int policyID);
	public Policy updatePolicy(int pid, Policy policy);
	public List<Policy> loadPoliciesByStatus(PolicyStatus status);

}

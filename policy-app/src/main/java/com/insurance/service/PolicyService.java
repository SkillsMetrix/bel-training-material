package com.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.dao.PolicyDAO;
import com.insurance.exceptions.PolicyNotFoundException;
import com.insurance.model.Policy;
import com.insurance.model.PolicyStatus;

@Service
public class PolicyService implements PolicyDAO {

	private List<Policy> policies = new ArrayList<Policy>();

	@Override
	public Policy createPolicy(Policy policy) {
		boolean exists = policies.stream().anyMatch(p -> p.getPolicyId() == policy.getPolicyId());
		if (exists) {
			throw new IllegalArgumentException("Policy already exists with ID " + policy.getPolicyId());
		}
		policies.add(policy);
		return policy;
	}

	@Override
	public List<Policy> loadPolicies() {
		// TODO Auto-generated method stub
		return policies;
	}

	@Override
	public Policy getPolicyByID(int pid) {

		return policies.stream().filter(policy -> policy.getPolicyId() == pid).findFirst()
				.orElseThrow(() -> new PolicyNotFoundException("Policy not found with ID " + pid));
	}

	@Override
	public void deletePolicy(int policyID) {
		Policy policy = getPolicyByID(policyID);
		policies.remove(policy);

	}

	@Override
	public Policy updatePolicy(int pid, Policy policy) {
		Policy existingPol = getPolicyByID(pid);
		existingPol.setPolicyHolderName(policy.getPolicyHolderName());
		existingPol.setPolicyStatus(policy.getPolicyStatus());
		existingPol.setPolicyType(policy.getPolicyType());
		existingPol.setPremiumAmount(policy.getPremiumAmount());
		return existingPol;
	}

	@Override
	public List<Policy> loadPoliciesByStatus(PolicyStatus status) {

		return policies.stream().filter(policy -> policy.getPolicyStatus() == status).toList();
	}

}

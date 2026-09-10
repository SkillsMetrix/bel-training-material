package com.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Policy {
	
	private int policyId;
	 
	private String policyHolderName;
	 
	private String policyType;
	 
	private PolicyStatus policyStatus;
	 
	private double premiumAmount;
	

}

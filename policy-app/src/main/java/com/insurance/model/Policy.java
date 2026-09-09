package com.insurance.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
	@NotNull(message = "Policy holder name is required")
	private String policyHolderName;
	@NotNull(message = "Policy type is required")
	private String policyType;
	@NotNull(message = "Policy status is required")
	private PolicyStatus policyStatus;
	//@NotBlank(message = "Policy amount is required")
	@Positive(message = "Policy amount must be greater than zero")
	private double premiumAmount;
	

}

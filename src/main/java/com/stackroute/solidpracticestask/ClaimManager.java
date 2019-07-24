package com.stackroute.solidpracticestask;

/**
 * ClaimManager approves the claim only when InsuranceSurveyor approves it. The class
 * extends Employee class and Implements InsuranceValidator which is used to validate the
 * insurance.
 */
public class ClaimManager extends Employee implements InsuranceValidator {

    @Override
    public void validateInsurance(Claim claim) {
        if ((claim.getInsurance() != null) && claim.isApprovedBySurveyor() && !claim.isClaimed() && !claim.getInsurance().isClaimed()) {
            claim.setApprovedByClaimManager(true);
        }
    }
}

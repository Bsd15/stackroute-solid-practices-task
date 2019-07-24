package com.stackroute.solidpracticestask;

/**
 * InsuranceSurveyor validates insurance and forwards the claim to the ClaimManager.
 * Extends Employee and implements InsuranceValidator to validate the insurance.
 */
public class InsuranceSurveyor extends Employee implements InsuranceValidator {

    @Override
    public void validateInsurance(Claim claim) {
        if (claim.getInsurance() != null && !claim.getInsurance().isClaimed() && !claim.isClaimed()) {
            claim.setApprovedBySurveyor(true);
        }
    }
}

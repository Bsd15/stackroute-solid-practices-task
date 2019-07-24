package com.stackroute.solidpracticestask;

/**
 * Claim is used to store the customer insurance details who has raised the claim.
 */
public class Claim {
    private int id;
    private Insurance insurance;
    private boolean isApprovedBySurveyor = false;
    private boolean isApprovedByClaimManager = false;
    private boolean isClaimed = false;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isApprovedBySurveyor() {
        return isApprovedBySurveyor;
    }

    public void setApprovedBySurveyor(boolean approvedBySurveyor) {
        isApprovedBySurveyor = approvedBySurveyor;
    }

    public boolean isApprovedByClaimManager() {
        return isApprovedByClaimManager;
    }

    public void setApprovedByClaimManager(boolean approvedByClaimManager) {
        isApprovedByClaimManager = approvedByClaimManager;
    }

    public boolean isClaimed() {
        return isClaimed;
    }

    public void setClaimed(boolean claimed) {
        isClaimed = claimed;
    }
}

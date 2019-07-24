package com.stackroute.solidpracticestask;

import java.util.ArrayList;
import java.util.List;

/**
 * Java - SOLID Practices Task
 * Question - 2
 * Consider an insurance system that validates health insurance claims before approving one. The
 * process is as follows:
 * A customer of the company files a claim
 * A health insurance surveyor validates a claim
 * A claim manager either approves or rejects the claim
 */
public class InsuranceCompany {
    public static void main(String[] args) {
        List<Claim> claimsList = new ArrayList<>();
//        Emulate the process of an insurance claim
        Customer customer = new Customer(1);
        System.out.println("Customer created with id " + customer.getId());
        Insurance insurance = new Insurance(customer);
        customer.setInsurance(insurance);
//        Start the claim
        claimsList = raiseClaim(customer, claimsList);
        for (Claim claim : claimsList) {
            resolveClaim(claim);
            issueClaimAmout(claim);
        }
    }

    private static void issueClaimAmout(Claim claim) {
        if (claim != null && claim.isApprovedByClaimManager() &&
                claim.isApprovedBySurveyor() && !claim.isClaimed() &&
                !claim.getInsurance().isClaimed()
        ) {
            claim.setClaimed(true);
            claim.getInsurance().setClaimed(true);
            System.out.println("Payment issued. Claim closed.");
        } else {
            System.out.println("Sorry unable to process claim. Check claim details and check if it's approved or not.");
        }
    }

    /**
     * Passes the claim to InsuranceSurveyor and ClaimManager to get approval and finally
     * prints the status of the claim.
     *
     * @param claim Claim to be resolved
     */
    private static void resolveClaim(Claim claim) {
        if (claim.getInsurance() != null && !claim.isClaimed() && !claim.getInsurance().isClaimed()) {
//            Create a Insurance Surveyor to validate the claim
            InsuranceValidator insuranceSurveyor = new InsuranceSurveyor();
            insuranceSurveyor.validateInsurance(claim);
            if (claim.isApprovedBySurveyor()) {
                System.out.println("Approved by Insurance Inspector. Claim Manager approval pending");
                InsuranceValidator claimManager = new ClaimManager();
                claimManager.validateInsurance(claim);
                if (claim.isApprovedByClaimManager()) {
                    System.out.println("Claim Approved by Claim Manager. Pending Transfer.");
                } else {
                    System.out.println("Claim rejected by Claim Manager.");
                }
            } else {
                System.out.println("Claim rejected by Insurace Supervisor.");
            }
        } else {
            System.out.println("Sorry your claim is not valid.");
        }
    }

    /**
     * Used to raise claims by customer
     *
     * @param customer   Customer whose claim is to be raise
     * @param claimsList Add the created claim to the claimsList and return it.
     * @return Update claimsList containing the new claim
     */
    private static List<Claim> raiseClaim(Customer customer, List<Claim> claimsList) {
        if (customer != null && customer.getInsurance() != null && !customer.getInsurance().isClaimed()) {
            Claim claim = new Claim();
            claim.setInsurance(customer.getInsurance());
            claimsList.add(claim);
        }
        return claimsList;
    }
}

package com.vito.policy;


public class PolicyInfo {
    private PolicyType policyType;

    private String policyStrCode;

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public String getPolicyStrCode() {
        return policyStrCode;
    }

    public void setPolicyStrCode(String policyStrCode) {
        this.policyStrCode = policyStrCode;
    }
}

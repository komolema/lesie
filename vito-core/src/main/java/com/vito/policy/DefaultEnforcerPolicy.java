package com.vito.policy;

import com.vito.framework.Policy;

/**
 * Created with IntelliJ IDEA.
 * User: karabom
 * Date: 4/1/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultEnforcerPolicy implements Policy {
    @Override
    public PolicyInfo generate() {
        PolicyInfo policyInfo = new PolicyInfo();

        policyInfo.setPolicyStrCode("System.out.println(\"Hello World\")");
        policyInfo.setPolicyType(PolicyType.ENFORCER);

        return policyInfo;
    }
}

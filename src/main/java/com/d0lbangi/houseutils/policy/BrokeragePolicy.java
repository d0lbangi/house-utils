package com.d0lbangi.houseutils.policy;

/**
 * @author d0lbangi
 *
 * 중개수수료 정책 인터페이스
 */
public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    default Long calculate(Long price) {
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }
}

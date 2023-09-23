package com.d0lbangi.houseutils.policy;

import com.d0lbangi.houseutils.exception.ErrorCode;
import com.d0lbangi.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author d0lbangi
 *
 * 중개수수료 정책 인터페이스
 */
public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {

        // 가격에 따른 룰을 찾아서 가져오는 로직

        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(()-> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }
}

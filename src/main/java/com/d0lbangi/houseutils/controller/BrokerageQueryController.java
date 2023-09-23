package com.d0lbangi.houseutils.controller;

import com.d0lbangi.houseutils.constants.ActionType;
import com.d0lbangi.houseutils.policy.BrokeragePolicy;
import com.d0lbangi.houseutils.policy.BrokeragePolicyFactory;
import com.d0lbangi.houseutils.policy.PurchaseBrokeragePolicy;
import com.d0lbangi.houseutils.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Happy
 */

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long CalcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        // TODO: 중개수수료 계산하는 로직
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}


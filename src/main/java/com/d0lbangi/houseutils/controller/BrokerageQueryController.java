package com.d0lbangi.houseutils.controller;

import com.d0lbangi.houseutils.constants.ActionType;
import com.d0lbangi.houseutils.policy.BrokeragePolicy;
import com.d0lbangi.houseutils.policy.BrokeragePolicyFactory;
import com.d0lbangi.houseutils.policy.PurchaseBrokeragePolicy;
import com.d0lbangi.houseutils.policy.RentBrokeragePolicy;
import com.d0lbangi.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Happy
 *
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 */

@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long CalcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        // TODO: 중개수수료 계산하는 로직
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId (
        @PathVariable Long apartmentId,
        @RequestParam ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}


package com.d0lbangi.houseutils.policy;

import com.d0lbangi.houseutils.constants.ActionType;
import com.d0lbangi.houseutils.exception.ErrorCode;
import com.d0lbangi.houseutils.exception.HouseUtilsException;

/**
 * @author Happy
 *
 */

public class BrokeragePolicyFactory {
    private static final  RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private static final  PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();



    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actiontype에 대한 정책이 존재하지 않습니다.");

        }
    }
}

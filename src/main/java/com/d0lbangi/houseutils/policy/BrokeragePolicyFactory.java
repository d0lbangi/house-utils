package com.d0lbangi.houseutils.policy;

import com.d0lbangi.houseutils.constants.ActionType;

/**
 * @author Happy
 *
 */

public class BrokeragePolicyFactory {
    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new IllegalArgumentException("해당 actiontype에 대한 정책이 존재하지 않습니다."); // 액션타입에 추가될 수 있으므로

        }
    }
}

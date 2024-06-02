package com.yo1000.saleslog.domain;

import java.security.SecureRandom;

public enum PointBehaviors {
    NOT_USE((plan, availablePoint) -> plan),
    RANDOM(new PointBehavior() {
        private final SecureRandom secureRandom = new SecureRandom();

        @Override
        public Sales usePoint(Sales plan, int availablePoint) {
            if (secureRandom.nextInt(4) > 0) {
                return plan;
            }
            int lower = Math.min(availablePoint, plan.total());
            if (lower <= 0) {
                return plan;
            }
            int usePoint = secureRandom.nextInt(lower) + 1;
            return new Sales(
                    plan.id(),
                    plan.dateTime(),
                    plan.discount(),
                    usePoint,
                    plan.total() - usePoint,
                    plan.items(),
                    plan.customer()
            );
        }
    }),
    FULL_PAYMENT_ONLY((plan, availablePoint) -> {
        if (plan.total() > availablePoint) {
            return plan;
        }
        return new Sales(
                plan.id(),
                plan.dateTime(),
                plan.discount(),
                plan.total(),
                0,
                plan.items(),
                plan.customer()
        );
    }),
    EXPENSIVE_PAYMENT_ONLY((plan, availablePoint) -> {
        if (plan.total() < 10_000 || availablePoint < 10_000) {
            return plan;
        }
        int usePoint = plan.total() / 10_000 * 10_000;
        while (usePoint > availablePoint) {
            usePoint -= 10_000;
        }
        return new Sales(
                plan.id(),
                plan.dateTime(),
                plan.discount(),
                usePoint,
                plan.total() - usePoint,
                plan.items(),
                plan.customer()
        );
    }),
    FRACTIONS_ONLY((plan, availablePoint) -> {
        int divisor = 1_000;
        while (divisor > 0 && plan.total() % divisor > availablePoint) {
            divisor /= 10;
        }
        int usePoint = divisor > 0
                ? plan.total() % divisor
                : 0;
        return new Sales(
                plan.id(),
                plan.dateTime(),
                plan.discount(),
                usePoint,
                plan.total() - usePoint,
                plan.items(),
                plan.customer()
        );
    })
    ;

    private final PointBehavior behavior;

    PointBehaviors(PointBehavior behavior) {
        this.behavior = behavior;
    }

    public PointBehavior behavior() {
        return behavior;
    }
}

package coupon;

import java.util.HashMap;
import java.util.Map;

public class CouponFactory {
    private Map<Integer, Coupon> coupons = new HashMap<>();
    public CouponFactory() {
        coupons.put(1, new Dollar1());
        coupons.put(2, new Dollar3());
        coupons.put(3, new Dollar5());
        coupons.put(4, new Dollar10());
    }

    public int getCouponCount() {
        return coupons.size();
    }

    public Coupon getCoupon(int id) {
        return coupons.get(id);
    }
}

package coupon;

import thread.Timer;
import user.User;
import validation.InputCheck;

import java.util.Random;

public class CouponManager {
    private Coupon coupon;
    private User user;
    private int couponId;

    InputCheck inputCheck = new InputCheck();

    public CouponManager(User user) {
        this.user = user;
    }

    public int askForCouponGet() {
        System.out.println(user.getName() + "님, 서비스 접속을 환영합니다!! 할인 쿠폰을 뽑으시겠습니까?(1: 예, 2: 아니오)");
        int choice = inputCheck.getValidChoiceInRange(2,1);
        return choice;
    }

    public void drawCoupon() {
        CouponFactory couponFactory = new CouponFactory();

        int couponCount = couponFactory.getCouponCount(); //쿠폰 개수 : 4개
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        couponId = random.nextInt(couponCount) + 1; // 0 ~ 3 -> 1 ~ 4
        coupon =  couponFactory.getCoupon(couponId);
    }

    public void playCoupon() {
        int choice = askForCouponGet();
        if (choice == 2) return;

        drawCoupon();
        System.out.println(user.getName() + "님, 지금부터 " + coupon.getTime() + "초 안에 주문하신다면 " + coupon.getSalePrice() + "원의 할인을 받을 수 있습니다!!");

        Timer timer = Timer.getInstance(coupon);
        timer.start();
    }

}

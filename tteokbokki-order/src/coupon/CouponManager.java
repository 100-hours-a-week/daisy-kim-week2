package coupon;

import design.LinePrint;
import thread.CouponTimer;
import user.User;
import validation.InputCheck;

import java.util.Random;

public class CouponManager {
    private Coupon coupon;
    private User user;
    private int couponId;
    private CouponFactory couponFactory = new CouponFactory();

    InputCheck inputCheck = new InputCheck();

    public CouponManager(User user) {
        this.user = user;
    }

    public int askForCouponGet() {
        showCouponList();
        int choice = inputCheck.getValidChoiceInRange(2,1);
        return choice;
    }

    public void showCouponList() {
        LinePrint.printBottomLine();
        System.out.println("\t\t\t\t\t\t[쿠 폰 목 록]");
        for (int i = 1; i <= couponFactory.getCouponCount(); i++) {
            System.out.println("\t\t\t\t<" + couponFactory.getCoupon(i).getTime() +  "초 안에 결제 시 " + couponFactory.getCoupon(i).getSalePrice() + "원 할인>");
        }
        LinePrint.printBottomLine();
        System.out.println(user.getName() + "님께 랜덤으로 위 쿠폰들 중 하나를 랜덤으로 드립니다!!! 할인 쿠폰을 뽑으시겠습니까? (1: 예, 2: 아니오)");
    }

    public void drawCoupon() {
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

        CouponTimer couponTimer = CouponTimer.getInstance(coupon);
        couponTimer.start();
    }

}

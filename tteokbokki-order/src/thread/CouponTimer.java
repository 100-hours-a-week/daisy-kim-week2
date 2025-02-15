package thread;

import coupon.Coupon;
import design.LinePrint;

public class CouponTimer extends Thread {
    private Coupon coupon;
    private static CouponTimer couponTimer;
    public boolean shouldWait = false;

    private CouponTimer(Coupon coupon) {
        this.coupon = coupon;
    }
    private CouponTimer() {}

    public static CouponTimer getInstance(Coupon coupon) {
        if (couponTimer == null) {
            couponTimer = new CouponTimer(coupon);
        }
        return couponTimer;
    }
    public static CouponTimer getInstance() {
        if (couponTimer == null) {
            couponTimer = new CouponTimer();
        }
        return couponTimer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void stopThread() {
        if (couponTimer != null)
            super.interrupt();
    }

    @Override
    public synchronized void run() {
        int timeLeft = coupon.getTime();

        while(timeLeft > 0) {
            if (shouldWait) {
                try {
                    couponTimer.wait();
                } catch (InterruptedException e) {
                    if (!coupon.getIsSold())
                        System.out.println("쿠폰 타이머 활성화");
                    else {
                        System.out.println("쿠폰을 사용하였습니다.");
                        break;
                    }
                }
                continue;
            }
            timeLeft--;
            if (timeLeft % 10 == 0) {
                LinePrint.printTopLine();
                System.out.println("\t\t\t\t쿠폰 사용 가능한 시간 " + timeLeft + "초 남았습니다.");
                LinePrint.printBottomLine();
            }

            try {
                Thread.sleep(1000); //1초
            } catch (InterruptedException e) {
                System.out.println("더 이상 쿠폰을 사용하실 수 없습니다.");
                break;
            }
        }

        if (timeLeft == 0)
            System.out.println("쿠폰 사용 시간이 종료되었습니다.");
    }

}

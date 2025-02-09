package timer;

import coupon.Coupon;

public class Timer extends Thread {
    private Coupon coupon;
    private static Timer timer;

    private Timer(Coupon coupon) {
        this.coupon = coupon;
    }

    public static Timer getInstance(Coupon coupon) {
        if (timer == null) {
            timer = new Timer(coupon);
        }
        return timer;
    }

    public static Timer getInstance() {
        return timer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void stopThread() {
        super.interrupt();
    }

    @Override
    public void run() {
        int timeLeft = coupon.getTime();

        while(timeLeft > 0) {
            System.out.println("\n쿠폰 사용 가능한 시간 " + timeLeft + "초 남았습니다.");
            try {
                Thread.sleep(10000); //10초
            } catch (InterruptedException e) {
                System.out.println("쿠폰을 사용하였습니다.");
                break;
            }
            timeLeft = timeLeft - 10;
        }

        if (timeLeft == 0)
            System.out.println("쿠폰 사용 시간이 종료되었습니다.");
    }

}

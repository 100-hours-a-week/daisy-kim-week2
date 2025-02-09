package thread;

import coupon.Coupon;
import design.LinePrint;

public class Timer extends Thread {
    private Coupon coupon;
    private static Timer timer;
    public boolean shouldWait = false;

    private Timer(Coupon coupon) {
        this.coupon = coupon;
    }
    private Timer() {}

    public static Timer getInstance(Coupon coupon) {
        if (timer == null) {
            timer = new Timer(coupon);
        }
        return timer;
    }
    public static Timer getInstance() {
        if (timer == null) {
            timer = new Timer();
        }
        return timer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void stopThread() {
        if (timer != null)
            super.interrupt();
    }

    @Override
    public synchronized void run() {
        int timeLeft = coupon.getTime();

        while(timeLeft > 0) {
            if (shouldWait) {
                try {
                    timer.wait();
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

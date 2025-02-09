package thread;

import coupon.Coupon;

public class Timer extends Thread {
    private Coupon coupon;
    private static Timer timer;
    private Timer(Coupon coupon) {
        this.coupon = coupon;
    }

    public boolean shouldWait = false;

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
    public synchronized void run() {
        int timeLeft = coupon.getTime();

        while(timeLeft > 0) {
            if (shouldWait) { //스레드 대기
                try {
                    timer.wait();
                } catch (InterruptedException e) { //스레드 대기하기하는 거 중단
                    System.out.println("쿠폰 사용 완료");
                    break;
                }
                continue;
            }

            timeLeft--;
            if (timeLeft % 10 == 0) {
                System.out.println("===== 쿠폰 사용 가능한 시간 " + timeLeft + "초 남았습니다. =====");
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

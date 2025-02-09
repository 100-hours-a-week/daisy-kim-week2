import coupon.CouponManager;
import order.Cart;
import order.Order;
import order.Payment;
import thread.Timer;
import user.User;
import validation.InputCheck;

public class Main {
    public static void main(String[] args) {

        System.out.println("엽기 떡볶이에 오신 것을 환영합니다.");
        User user = User.setUserInfo();
        CouponManager couponManager = new CouponManager(user);
        couponManager.playCoupon();
        InputCheck ic = new InputCheck();

        while(true) {
            //주문
            Timer.getInstance().shouldWait = true;
            System.out.println("\n새 주문을 시작합니다. 동의하십니까? (1: 예, 2: 아니오)");
            int input = ic.getValidChoiceInRange(2, 1);
            Timer.getInstance().stopThread();
            Timer.getInstance().shouldWait = false;


            if (input == 2) {
                printShutDown();
                break;
            }

            Order order = new Order(user);
            Cart cart = order.order();
            Payment payment = new Payment(user, cart);
            payment.pay();
        }
    }

    private static void printShutDown() {
        Timer timer = Timer.getInstance();
        timer.stopThread(); //스레드 interrupt

        System.out.println("\n+=========================================================+");
        System.out.println("\t\t\tdaisy의 엽기 떡볶이 주문 서비스를 종료합니다.");
        System.out.println("\t\t\t\t\t\t다음에 또 봐요~");
        System.out.println("+=========================================================+");
    }
}
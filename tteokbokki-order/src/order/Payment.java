package order;

import coupon.Coupon;
import design.LinePrint;
import thread.Timer;
import user.User;
import validation.InputCheck;

public class Payment {
    private final User user;
    private final Cart cart;
    InputCheck inputCheck = new InputCheck();

    private Timer timer = Timer.getInstance();
    private Coupon coupon = timer == null ? null : timer.getCoupon();

    public Payment(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

    public boolean askForPayment() {
        boolean isPositive = false;

        LinePrint.printTopLine();
        cart.printCart();
        printCouponSale();
        LinePrint.printBottomLine();

        timer.shouldWait = true;
        System.out.println("결제하시겠습니까?(1: 예, 2: 아니오) : ");
        int choice = inputCheck.getValidChoiceInRange(2,1);
        coupon.setIsSold(true);
        timer.shouldWait = false;

        if(choice == 1) {
            isPositive = true;
        }
        return isPositive;
    }

    public void printCouponSale() {
        if (timer != null && timer.isAlive())
            System.out.println("(추가 할인될 가격 : " + coupon.getSalePrice() +"원)");
    }

    public int calculateCouponAppliedPrice(){
        int payingPrice = cart.getTotalPrice();

        if (timer != null && timer.isAlive()) {
            if (payingPrice > coupon.getSalePrice()) {
                payingPrice -= coupon.getSalePrice();
            } else {
                payingPrice = 0;
            }
        }
        return payingPrice;
    }

    public void pay() {
        boolean payAbility = false;
        boolean opinion = askForPayment();

        while(opinion) {
            int payingPrice = calculateCouponAppliedPrice();
            cart.updateTotalPrice(payingPrice);

            if (user.getCardBalance() >= payingPrice) {
                user.updateCardBalance(user.getCardBalance() - cart.getTotalPrice());
                timer.stopThread();
                payAbility = true;
            }
            showPayResult(payAbility);
            if(payAbility) {
                break;
            }
            opinion = retryPayment();
        }
    }

    public void showPayResult(boolean result) {
        if (result) {
            System.out.println("\n결제가 완료되었습니다.");
            System.out.println("결제 금액은 " + cart.getTotalPrice() + "원입니다.");
            System.out.println("현재 남은 잔액은 " + user.getCardBalance() + "원입니다.\n");
        } else {
            System.out.println("\n카드에 잔액이 부족합니다.");
        }
    }
    public boolean retryPayment() {
        System.out.print("카드 잔액을 채우시겠습니까? (1: 예, 2: 아니오) : ");
        int choice = inputCheck.getValidChoiceInRange(2,1);
        if (choice == 2) {
            System.out.println("결제에 실패하여 처음으로 돌아갑니다.");
            return false;
        }
        System.out.print("얼마를 채우시겠습니까? : ");
        int addingPrice = inputCheck.getValidCardBalance();
        user.updateCardBalance(user.getCardBalance() + addingPrice);
        return true;
    }
}

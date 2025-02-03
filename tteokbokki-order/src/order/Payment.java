package order;

import menu.Menu;
import user.User;
import validation.InputCheck;

public class Payment {
    private final User user;
    private final Cart cart;
    InputCheck ic = new InputCheck();

    public Payment(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

    public boolean askForPayment(){
        boolean isPositive = false;
        cart.printCart();
        System.out.println("결제하시겠습니까?(1: 예, 2: 아니오) : ");

        int choice = ic.getValidChoiceInRange(2,1);
        if(choice == 1) {
            isPositive = true;
        }
        return isPositive;
    }

    public void pay() {
        boolean payAbility = false;
        boolean opinion = askForPayment();

        while(opinion) {
            if (user.getCardBalance() >= cart.getTotalPrice()) {
                user.updateCardBalance(user.getCardBalance() - cart.getTotalPrice());
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
            System.out.println("결제 금액은 " + cart.getTotalPrice() + "입니다.");
            System.out.println("현재 남은 잔액은 " + user.getCardBalance() + "입니다.\n");
        } else {
            System.out.println("\n카드에 잔액이 부족합니다.");
        }
    }
    public boolean retryPayment() {
        System.out.print("카드 잔액을 채우시겠습니까? (1: 예, 2: 아니오) : ");
        int choice = ic.getValidChoiceInRange(2,1);
        if (choice == 2) {
            System.out.println("결제에 실패하여 처음으로 돌아갑니다.");
            return false;
        }
        System.out.print("얼마를 채우시겠습니까? : ");
        int addingPrice = ic.getValidCardBalance();
        user.updateCardBalance(user.getCardBalance() + addingPrice);
        return true;
    }
}

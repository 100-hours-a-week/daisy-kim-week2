import order.Cart;
import order.Order;
import order.Payment;
import user.User;
import validation.InputCheck;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        System.out.println("엽기 떡볶이에 오신 것을 환영합니다.");
        User user = User.setUserInfo();
        InputCheck ic = new InputCheck();

        while(true) {
            //주문
            System.out.println("\n새 주문을 시작합니다. 동의하십니까? (1: 예, 2: 아니오)");
            int input = ic.getValidChoiceInRange(2, 1);
            if (input == 2) {
                System.out.println("\n어플을 종료합니다.");
                break;
            }

            Order order = new Order(user);
            Cart cart = order.order();
            Payment payment = new Payment(user, cart);
            payment.pay();
        }
    }
}
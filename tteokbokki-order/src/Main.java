import order.Order;
import user.User;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        System.out.println("엽기 떡볶이에 오신 것을 환영합니다.");

        //앱을 켤 때마다 = 프로그램을 실행시킬 때마다 -> static
        User user = User.setUserInfo();

        Scanner sc = new Scanner(System.in);
        while(true) {
            //주문
            System.out.println("새 주문을 시작합니다. 동의하십니까? (1: 예, 2: 아니오)");
            int input = sc.nextInt();
            if (input == 2) {
                System.out.println("어플을 종료합니다.");
                break;
            }

            Order order = new Order(user);
            order.order();
        }
    }
}
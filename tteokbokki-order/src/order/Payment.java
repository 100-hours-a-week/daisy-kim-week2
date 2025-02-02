package order;

import menu.Menu;
import user.User;

import java.util.List;
import java.util.Scanner;

public class Payment {
    User user;
    Scanner sc = new Scanner(System.in);

    public Payment(User user) {
        this.user = user;
    }

    //결제 의사 물어보기
    public void askForPayment(List<Menu> cart, int totalPrice){
        for (Menu menu : cart) {
            System.out.println(menu.getName());
        }
        System.out.println("총 가격은 " + totalPrice + "입니다.");
        System.out.println("결제하시겠습니까?(1: 예, 2: 아니오) : ");
        int choice = sc.nextInt();

        if(choice == 1) {
            payResult(cart, totalPrice);
        } else {
            System.out.println("결제를 취소하였습니다.");
        }
    }

    public void payResult(List<Menu> cart, int totalPrice) {
        boolean result = pay(totalPrice);
        if (result) {
            for (Menu menu : cart) {
                System.out.println(menu.getName());
            }
            System.out.println("결제 금액은 " + totalPrice + "입니다.");
            System.out.println("현재 남은 잔액은 " + user.getCardBalance() + "입니다.\n");
        } else {
            System.out.println("카드에 잔액이 부족합니다." + "\n");
        }
    }

    //실제 결제
    public boolean pay(int payingPrice) {
        boolean result = false;
        if (user.getCardBalance() >= payingPrice) {
            user.updateCardBalance(user.getCardBalance() - payingPrice);
            result = true;
        }
        return result;
    }
}

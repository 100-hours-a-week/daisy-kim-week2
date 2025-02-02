package order;

import menu.Menu;
import menu.Tteokbokki;
import menu.topping.Topping;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private final User user;
    private final List<Menu> cart = new ArrayList<>();

    private int price = 0;
    private String name = "";
    private int totalPrice = 0;

    public Order(User user) {
        this.user = user;
    }

    Scanner sc = new Scanner(System.in);

    //주문 로직(반복 회로)
    public void order() {
       while(true) {
           selectItem();
           cart.add(new Menu(name, price));
           totalPrice += price;

           System.out.print("더 주문하시겠습니까? (1: 예, 2: 아니오) : ");
           int choice = sc.nextInt();
           if(choice == 2) {
               break;
           }
           price = 0;
           name = "";
       }
       Payment payment = new Payment(user);
       payment.askForPayment(cart, totalPrice);
    }

    //한 개 주문하기
    public void selectItem() {
        System.out.println("주문할 메뉴를 선택해 주세요.\n" +
                "[떡볶이]\n 1: 엽기 메뉴, 2: 로제 메뉴, 3: 마라떡볶이, 4: 마라로제 떡볶이\n" +
                "[사이드]\n 5: 단무지, 6: 주시쿨");

        Menu menu = null;
        Tteokbokki tteokbokki = null;

        int choice = sc.nextInt();
        if (choice <= 4) {
            TteokbokkiFactory ttf = new TteokbokkiFactory();
            tteokbokki = ttf.getTteokbokki(choice);
            String spicyLevelName = tteokbokki.selectSpicyLevel();
            name = tteokbokki.getName() + " " + spicyLevelName;
            price = tteokbokki.getPrice();

            selectTopping();
        } else {
            MenuFactory mf = new MenuFactory();
            menu = mf.getMenu(choice);
            name = menu.getName();
            price = menu.getPrice();
        }
    }

    //토핑 고르기
    public void selectTopping() {
        ToppingFactory toppingFactory = new ToppingFactory();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("원하는 토핑을 골라주세요.(0~3개) \n(1: 떡 추가, 2: 오뎅 추가, 3: 우삼겹, 4: 통유부(4개), 5: 퐁당치즈만두(7개), 6: 중국당면, 7: 분모자, 0: 토핑 선택 안 함): ");
            int toppingChoice = sc.nextInt();
            if (toppingChoice == 0)
                break;

            Topping topping = toppingFactory.getTopping(toppingChoice);
            List<Topping> toppingList = new ArrayList<> ();
            toppingList.add(topping);

            name += " " + topping.getName() + "추가";
            price += topping.getPrice();
        }
    }
}

package order;

import menu.Menu;
import menu.Tteokbokki;
import menu.topping.Topping;
import user.User;
import validation.InputCheck;

public class Order {
    private final User user;
    private int price = 0;
    private String name = "";

    private static final TteokbokkiFactory ttf = new TteokbokkiFactory();
    private static final SideMenuFactory mf = new SideMenuFactory();
    private static final ToppingFactory toppingFactory = new ToppingFactory();

    private final InputCheck ic = new InputCheck();

    public Order(User user) {
        this.user = user;
    }

    //주문 로직(반복 회로)
    public Cart order() {
        Cart cart = new Cart(user);

        while(true) {
            selectItem();
            int choice = 0;

            System.out.print("\n1: 장바구니에 담기, 2: 메뉴 다시 담기 : ");
            choice = ic.getValidChoiceInRange(2,1);
            if(choice == 2) {
                continue;
            }
            cart.addMenu(new Menu(name, price));

            System.out.print("더 주문하시겠습니까? (1: 예, 2: 아니오) : ");
            choice = ic.getValidChoiceInRange(2, 1);
            if(choice == 2) {
                break;
            }

            price = 0;
            name = "";
        }
        return cart;
    }

    public void selectItem() {
        showMenus();
        int tbkCnt = ttf.getTteokbokkiCount();
        int menuCnt = tbkCnt + mf.getMenuCount();

        int choice = ic.getValidChoiceInRange(menuCnt, 1);
        while(true) {
            if (choice != 0) break;
            System.out.println("잘못된 입력입니다. 선택지에 있는 번호를 입력해 주세요.");
        }
        if (choice <= tbkCnt) {
            Tteokbokki tteokbokki = ttf.getTteokbokki(choice);
            String spicyLevelName = tteokbokki.selectSpicyLevel();
            name = tteokbokki.getName() + " " + spicyLevelName;
            price = tteokbokki.getPrice();

            selectTopping();
        } else {
            Menu menu = mf.getMenu(choice);
            name = menu.getName();
            price = menu.getPrice();
        }
    }

    //토핑 고르기
    public void selectTopping() {
        int maxToppingCntAbility = 3;
        int toppingCnt = toppingFactory.getToppingCount();

        for (int i = 0; i < maxToppingCntAbility; i++) {
            showToppings();
            int toppingChoice = ic.getValidChoiceInRange(toppingCnt, 0);
            if (toppingChoice == 0) break;

            Topping topping = toppingFactory.getTopping(toppingChoice);
            name += " " + topping.getName();
            price += topping.getPrice();
        }
    }

    public void showMenus() {
        int tbkCnt = ttf.getTteokbokkiCount();
        int menuCnt = tbkCnt + mf.getMenuCount();

        System.out.println("\n주문할 메뉴를 선택해 주세요.\n[떡볶이]");
        for(int i = 1; i <= tbkCnt; i++) {
            System.out.println(i + ": " + ttf.getTteokbokki(i).getName() + " +" + ttf.getTteokbokki(i).getPrice() + "원");
        }
        System.out.println("[사이드]");
        for(int i = tbkCnt + 1; i <= menuCnt; i++) {
            System.out.println(i + ": " + mf.getMenu(i).getName() + " +" + mf.getMenu(i).getPrice() + "원");
        }
    }

    public void showToppings() {
        System.out.println("\n원하는 토핑을 골라주세요.(0~3개)");
        int toppingCnt = toppingFactory.getToppingCount();

        for (int j = 0; j < toppingCnt; j++) {
            System.out.println(j + ": " + toppingFactory.getTopping(j).getName() +
                    " +" + toppingFactory.getTopping(j).getPrice() + "원");
        }
    }
}

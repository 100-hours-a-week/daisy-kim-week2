package order;

import menu.Menu;
import user.User;
import validation.InputCheck;

public class Order {
    private final User user;
    private int price = 0;
    private String name = "";

    private static final Factory tteokbokkiFactory = new TteokbokkiFactory();
    private static final Factory sideMenuFactory = new SideMenuFactory();
    private static final Factory toppingFactory = new ToppingFactory();

    private int tteokbokkiCount = tteokbokkiFactory.getTotalNumber();
    private int menuCount = tteokbokkiCount + sideMenuFactory.getTotalNumber();
    private int toppingCnt = toppingFactory.getTotalNumber();

    private final InputCheck inputCheck = new InputCheck();

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
            choice = inputCheck.getValidChoiceInRange(2,1);
            if(choice == 2) {
                continue;
            }
            cart.addMenu(new Menu(name, price));

            System.out.print("더 주문하시겠습니까? (1: 예, 2: 아니오) : ");
            choice = inputCheck.getValidChoiceInRange(2, 1);
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

        int choice = inputCheck.getValidChoiceInRange(menuCount, 1);
        while(true) {
            if (choice != 0) break;
            System.out.println("잘못된 입력입니다. 선택지에 있는 번호를 입력해 주세요.");
        }

        if (choice <= tteokbokkiCount) {
            Menu tteokbokki = tteokbokkiFactory.getMenuName(choice);
            String spicyLevelName = tteokbokki.selectSpicyLevel();
            name = tteokbokki.getName() + " " + spicyLevelName;
            price = tteokbokki.getPrice();

            selectTopping();
        } else {
            Menu menu = sideMenuFactory.getMenuName(choice);
            name = menu.getName();
            price = menu.getPrice();
        }
    }

    //토핑 고르기
    public void selectTopping() {
        int maxToppingCntAbility = 3;

        for (int i = 0; i < maxToppingCntAbility; i++) {
            showToppings();

            int toppingChoice = inputCheck.getValidChoiceInRange(toppingCnt, 0);
            if (toppingChoice == 0) break;

            Menu topping = toppingFactory.getMenuName(toppingChoice);
            name += " " + topping.getName();
            price += topping.getPrice();
        }
    }

    public void showMenus() {
        System.out.println("\n주문할 메뉴를 선택해 주세요.\n[떡볶이]");
        showList(tteokbokkiFactory, 1, tteokbokkiCount);

        System.out.println("[사이드]");
        showList(sideMenuFactory, tteokbokkiCount+1, menuCount);
    }

    public void showToppings() {
        System.out.println("\n원하는 토핑을 골라주세요.(0~3개)");
        showList(toppingFactory, 0, toppingCnt-1);
    }

    public void showList(Factory factoryItem, int startNum, int endNum) {
        for(int i = startNum; i <= endNum; i++) {
            System.out.println(i + ": " + factoryItem.getMenuName(i).getName() + " +" + factoryItem.getMenuName(i).getPrice() + "원");
        }
    }
}

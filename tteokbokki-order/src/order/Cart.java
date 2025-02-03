package order;

import menu.Menu;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int totalPrice = 0;
    private List<Menu> cartItems = new ArrayList<Menu>();
    private User user;

    public Cart(User user) {
        this.user = user;
    }

    public void addMenu(Menu menu) {
        cartItems.add(menu);
        totalPrice += menu.getPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Menu> getCartItems() {
        return cartItems;
    }

    public void printCart() {
        System.out.println("\n[" + user.getName() + "님의 장바구니]");
        for (Menu menu : cartItems) {
            System.out.println(menu.getName());
        }
        System.out.println("총 금액 : " + totalPrice + "\n");
    }
}

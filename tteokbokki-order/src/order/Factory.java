package order;

import menu.Menu;

public class Factory {
    public int getTotalNumber() {
        return 0;
    }
    public Menu getMenuName(int id) {
        return new Menu("", 0);
    }
}

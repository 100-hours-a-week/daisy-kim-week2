package order;

import menu.*;
import menu.side.Juice;
import menu.side.PickeledRadish;

import java.util.HashMap;
import java.util.Map;

public class SideMenuFactory {
    private final Map<Integer, Menu> menuMap;

    public SideMenuFactory() {
        menuMap = new HashMap<Integer, Menu>();
        menuMap.put(5, new PickeledRadish());
        menuMap.put(6, new Juice());
    }

    public Menu getMenu(int id) {
        return menuMap.get(id);
    }

    public int getMenuCount() {
        return menuMap.size();
    }
}

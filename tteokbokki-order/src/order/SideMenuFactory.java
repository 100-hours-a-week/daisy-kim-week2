package order;

import menu.*;
import menu.side.Juice;
import menu.side.PickeledRadish;

import java.util.HashMap;
import java.util.Map;

public class SideMenuFactory extends Factory {
    private final Map<Integer, Menu> menuMap;

    public SideMenuFactory() {
        menuMap = new HashMap<>();
        menuMap.put(5, new PickeledRadish());
        menuMap.put(6, new Juice());
    }

    public Menu getMenuName(int id) {
        return menuMap.get(id);
    }

    public int getTotalNumber() {
        return menuMap.size();
    }
}

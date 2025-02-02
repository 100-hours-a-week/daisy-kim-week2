package order;

import menu.*;
import menu.side.Juice;
import menu.side.PickeledRadish;

import java.util.HashMap;
import java.util.Map;

public class MenuFactory {
    private final Map<Integer, Menu> menuMap;

    public MenuFactory() {
        menuMap = new HashMap<Integer, Menu>();
        menuMap.put(5, new PickeledRadish());
        menuMap.put(6, new Juice());
    }

    public Menu getMenu(int id) {
        return menuMap.get(id);
    }
}

package order;

import menu.Menu;
import menu.topping.*;

import java.util.HashMap;
import java.util.Map;

public class ToppingFactory extends Factory {
    private final Map<Integer, Menu> toppingMap;

    public ToppingFactory() {
        toppingMap = new HashMap<>();
        toppingMap.put(0, new NoTopping());
        toppingMap.put(1, new TteokTopping());
        toppingMap.put(2, new OdangTopping());
        toppingMap.put(3, new MeatTopping());
        toppingMap.put(4, new YubuTopping());
        toppingMap.put(5, new CheeseManduTopping());
        toppingMap.put(6, new DangNoodleTopping());
        toppingMap.put(7, new BunmojaTopping());
    }

    public Menu getMenuName(int toppingChoice) {
        return toppingMap.get(toppingChoice);
    }

    public int getTotalNumber() {
        return toppingMap.size();
    }
}
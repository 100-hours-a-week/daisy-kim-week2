package order;

import menu.*;

import java.util.HashMap;
import java.util.Map;

public class TteokbokkiFactory extends Factory{
    private Map<Integer, Menu> tteokbokkiMap;

    public TteokbokkiFactory() {
        tteokbokkiMap = new HashMap<>();
        tteokbokkiMap.put(1, new YeopgiTteokbokki());
        tteokbokkiMap.put(2, new RoseTteokbokki());
        tteokbokkiMap.put(3, new MaraTteokbokki());
        tteokbokkiMap.put(4, new MaraRoseTteokbokki());
    }

    public Menu getMenuName(int id) {
        return tteokbokkiMap.get(id);
    }

    public int getTotalNumber() {
        return tteokbokkiMap.size();
    }
}

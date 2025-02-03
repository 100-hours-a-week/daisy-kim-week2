package order;

import menu.*;

import java.util.HashMap;
import java.util.Map;

public class TteokbokkiFactory {
    private Map<Integer, Tteokbokki> tteokbokkiMap;

    public TteokbokkiFactory() {
        tteokbokkiMap = new HashMap<Integer, Tteokbokki>();
        tteokbokkiMap.put(1, new YeopgiTteokbokki());
        tteokbokkiMap.put(2, new RoseTteokbokki());
        tteokbokkiMap.put(3, new MaraTteokbokki());
        tteokbokkiMap.put(4, new MaraRoseTteokbokki());
    }

    public Tteokbokki getTteokbokki(int id) {
        return tteokbokkiMap.get(id);
    }
    public int getTteokbokkiCount() {
        return tteokbokkiMap.size();
    }
}

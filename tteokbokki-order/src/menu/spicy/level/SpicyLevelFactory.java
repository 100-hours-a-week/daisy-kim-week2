package menu.spicy.level;

import java.util.HashMap;
import java.util.Map;

public class SpicyLevelFactory {
    private final Map<Integer, String> spicyLevel;

    public SpicyLevelFactory(int type) {
        spicyLevel = new HashMap<Integer, String>();

        if (type == 1) {
            spicyLevel.put(1, "착한맛");
            spicyLevel.put(2, "착한맛");
            spicyLevel.put(3, "덜매운맛");
            spicyLevel.put(4, "오리지널");
            spicyLevel.put(5, "매운맛");
        } else if (type == 2) {
            spicyLevel.put(1, "착한맛");
            spicyLevel.put(2, "오리지널");
        }
    }

    public String selectSpicyLevel(int level) {
        return spicyLevel.get(level);
    }
}

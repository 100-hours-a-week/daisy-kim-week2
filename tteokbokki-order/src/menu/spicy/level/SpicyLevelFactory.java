package menu.spicy.level;

public class SpicyLevelFactory {
    private SpicyLevel[] levels = new SpicyLevel[SpicyLevel.values().length];

    public SpicyLevelFactory(int type) {

        if (type == 1) {
            levels = SpicyLevel.values();
        } else if (type == 2) {
            levels[0] = SpicyLevel.착한맛;
            levels[1] = SpicyLevel.오리지널;
        }
    }

    public String selectSpicyLevel(int choice) {
        return String.valueOf(levels[choice - 1]);
    }
}

enum SpicyLevel {
    착한맛, 초보맛, 덜매운맛, 오리지널, 매운맛
}

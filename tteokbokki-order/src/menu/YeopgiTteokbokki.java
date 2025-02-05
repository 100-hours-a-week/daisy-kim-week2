package menu;

import menu.spicy.level.SpicyLevelFactory;

public class YeopgiTteokbokki extends Tteokbokki {
    private static final String NAME = "엽기메뉴";
    private static final int PRICE = 14000;

    public YeopgiTteokbokki() {
        super(NAME, PRICE);
    }

    @Override
    public String selectSpicyLevel() {
        SpicyLevelFactory slf = new SpicyLevelFactory(1);

        System.out.println("\n매운 맛 정도를 선택하세요. (1: 착한맛, 2: 초보맛, 3: 덜매운맛, 4: 오리지널, 5: 매운맛) : ");
        int spicyLevel = inputCheck.getValidChoiceInRange(5, 1);
        return slf.selectSpicyLevel(spicyLevel);
    }
}

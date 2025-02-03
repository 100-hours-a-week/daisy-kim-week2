package menu;

import menu.spicy.level.SpicyLevelFactory;
import validation.InputCheck;

public class YeopgiTteokbokki extends Tteokbokki {
    private static final String name = "엽기메뉴";
    private static final int price = 14000;
    InputCheck ic = new InputCheck();

    public YeopgiTteokbokki() {
        super(name, price);
    }

    @Override
    public String selectSpicyLevel() {
        SpicyLevelFactory slf = new SpicyLevelFactory(1);

        System.out.println("\n매운 맛 정도를 선택하세요. (1: 착한맛, 2: 초보맛, 3: 덜매운맛, 4: 오리지널, 5: 매운맛) : ");
        int spicyLevel = ic.getValidChoiceInRange(5, 1);
        return slf.selectSpicyLevel(spicyLevel);
    }
}

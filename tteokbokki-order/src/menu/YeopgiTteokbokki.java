package menu;

import menu.spicy.level.SpicyLevelFactory;

import java.util.Scanner;

public class YeopgiTteokbokki extends Tteokbokki {
    private static final String name = "엽기메뉴";
    private static final int price = 14000;

    public YeopgiTteokbokki() {
        super(name, price);
    }

    @Override
    public String selectSpicyLevel() {
        SpicyLevelFactory slf = new SpicyLevelFactory(1);

        Scanner sc = new Scanner(System.in);
        System.out.println("매운 맛 정도를 선택하세요. (1: 착한맛, 2: 초보맛, 3: 덜매운맛, 4: 오리지널, 5: 매운맛) : ");
        int spicyLevel = sc.nextInt();
        return slf.selectSpicyLevel(spicyLevel);
    }
}

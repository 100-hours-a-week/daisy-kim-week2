package menu;

import menu.spicy.level.SpicyLevelFactory;

import java.util.Scanner;

public class Tteokbokki extends Menu {
    public Tteokbokki(String name, int price) {
        super(name, price);
    }

    public String selectSpicyLevel() {
        SpicyLevelFactory slf = new SpicyLevelFactory(2);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n매운 맛 정도를 선택하세요. (1: 착한맛, 2: 오리지널) : ");
        int spicyLevel = sc.nextInt();
        return slf.selectSpicyLevel(spicyLevel);
    }
}

package menu;

import menu.spicy.level.SpicyLevelFactory;
import validation.InputCheck;

import java.util.Scanner;

public class Tteokbokki extends Menu {
    InputCheck ic = new InputCheck();

    public Tteokbokki(String name, int price) {
        super(name, price);
    }

    public String selectSpicyLevel() {
        SpicyLevelFactory slf = new SpicyLevelFactory(2);

        System.out.println("\n매운 맛 정도를 선택하세요. (1: 착한맛, 2: 오리지널) : ");
        int spicyLevel = ic.getValidChoiceInRange(2,1);
        return slf.selectSpicyLevel(spicyLevel);
    }
}

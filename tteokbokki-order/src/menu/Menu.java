package menu;
import validation.InputCheck;

public class Menu {
    private String name;
    private int price;
    InputCheck inputCheck = new InputCheck();

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String selectSpicyLevel() {
        System.out.println("맵기 단계를 선택합니다.");
        return "맵기 단계";
    }
}

package menu.topping;

public class NoTopping extends Topping {
    private static final String name = "토핑 추가 안 함";
    private static final int price = 0;

    public NoTopping() {
        super(name, price);
    }
}

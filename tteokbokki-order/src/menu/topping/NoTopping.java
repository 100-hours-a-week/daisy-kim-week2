package menu.topping;

public class NoTopping extends Topping {
    private static final String NAME = "토핑 추가 안 함";
    private static final int PRICE = 0;

    public NoTopping() {
        super(NAME, PRICE);
    }
}

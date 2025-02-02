package order;

import menu.topping.*;

import java.util.HashMap;
import java.util.Map;

public class ToppingFactory {
    private final Map<Integer, Topping> toppingMap;

    public ToppingFactory() {
        toppingMap = new HashMap<>();
        toppingMap.put(1, new TteokTopping());
        toppingMap.put(2, new OdangTopping());
        toppingMap.put(3, new MeatTopping());
        toppingMap.put(4, new YubuTopping());
        toppingMap.put(5, new CheeseManduTopping());
        toppingMap.put(6, new DangNoodleTopping());
        toppingMap.put(7, new BunmojaTopping());
    }

    //떡볶이 대응시켜서 반환하기
    public Topping getTopping(int toppingChoice) {
        return toppingMap.get(toppingChoice);
    }
}
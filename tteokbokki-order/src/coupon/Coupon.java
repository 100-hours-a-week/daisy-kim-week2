package coupon;

public class Coupon {
    int time;
    int salePrice;

    public Coupon(int time, int salePrice) {
        this.time = time;
        this.salePrice = salePrice;
    }

    public int getTime() {
        return time;
    }

    public int getSalePrice() {
        return salePrice;
    }
}

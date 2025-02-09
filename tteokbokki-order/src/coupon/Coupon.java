package coupon;

public class Coupon {
    private int time;
    private int salePrice;
    private boolean sold = false;

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

    public boolean getIsSold() {
        return sold;
    }
    public void setIsSold(boolean sold) {
        this.sold = sold;
    }
}

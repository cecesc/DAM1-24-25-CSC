package contornos.ud3;

public class DiscountCalculator {

    public static double applyDiscount(double price, double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Desconto non válido");
        }
        return price - (price * discount / 100);
    }
}

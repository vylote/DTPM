package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 1C: Thanh toán thẻ ATM nội địa Napas 247.
 */
public class NapasCardStrategy implements PaymentStrategy {
    @Override
    public String getStrategyName() {
        return "Thẻ ATM Nội Địa Napas 247";
    }

    @Override
    public void pay(double amount, String orderId) {
        System.out.println(String.format(
            "   [Napas 247] Xác thực OTP ngân hàng cho đơn [%s] | Số tiền: %,.0f VNĐ -> Cổng thanh toán quốc gia Napas xác nhận!",
            orderId, amount
        ));
    }
}

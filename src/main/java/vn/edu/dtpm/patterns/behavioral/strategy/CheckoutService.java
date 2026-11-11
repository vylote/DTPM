package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Context: Đơn hàng thanh toán cho phép đổi chiến lược thanh toán linh hoạt tại runtime.
 */
public class CheckoutService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("[CheckoutService] Khách hàng chuyển sang phương thức: " + paymentStrategy.getStrategyName());
    }

    public void processOrderPayment(String orderId, double amount) {
        if (paymentStrategy == null) {
            System.out.println("[CheckoutService] Lỗi: Chưa chọn phương thức thanh toán!");
            return;
        }
        paymentStrategy.pay(amount, orderId);
    }
}

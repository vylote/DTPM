package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Strategy Interface 1: Chiến lược thanh toán đơn hàng trực tuyến.
 */
public interface PaymentStrategy {
    void pay(double amount, String orderId);
    String getStrategyName();
}

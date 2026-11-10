package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Strategy Interface 1: Chiến lược thanh toán đơn hàng trực tuyến.
 */
public interface PaymentStrategy {
    void pay(double amount, String orderId);
    String getStrategyName();
}

/**
 * Concrete Strategy 1A: Thanh toán qua Cổng VNPay QR (Ngân hàng số).
 */
class VNPayQRStrategy implements PaymentStrategy {
    @Override
    public String getStrategyName() {
        return "VNPay QR (Quét mã trên ứng dụng Mobile Banking)";
    }

    @Override
    public void pay(double amount, String orderId) {
        System.out.println(String.format(
            "   [VNPay QR] Đang sinh mã VNPAY-QR cho đơn [%s] | Số tiền: %,.0f VNĐ. Khách hàng quét mã qua Vietcombank/BIDV app -> Thanh toán thành công!",
            orderId, amount
        ));
    }
}

/**
 * Concrete Strategy 1B: Thanh toán qua Ví điện tử MoMo.
 */
class MoMoWalletStrategy implements PaymentStrategy {
    @Override
    public String getStrategyName() {
        return "Ví Điện Tử MoMo (Tích điểm hoàn tiền)";
    }

    @Override
    public void pay(double amount, String orderId) {
        System.out.println(String.format(
            "   [Ví MoMo] Khấu trừ ví MoMo cho đơn [%s] | Số tiền: %,.0f VNĐ -> Giao dịch thành công, tích 25 điểm MoMo Rewards!",
            orderId, amount
        ));
    }
}

/**
 * Concrete Strategy 1C: Thanh toán thẻ ATM nội địa Napas 247.
 */
class NapasCardStrategy implements PaymentStrategy {
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

/**
 * Context: Đơn hàng thanh toán cho phép đổi chiến lược thanh toán linh hoạt tại runtime.
 */
class CheckoutService {
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


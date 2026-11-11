package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 1A: Thanh toán qua Cổng VNPay QR (Ngân hàng số).
 */
public class VNPayQRStrategy implements PaymentStrategy {
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

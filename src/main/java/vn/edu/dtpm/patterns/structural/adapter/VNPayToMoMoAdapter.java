package vn.edu.dtpm.patterns.structural.adapter;

/**
 * Cài đặt cổng thanh toán VNPay thực tế.
 */
class VNPayImpl implements VNPayPayable {
    @Override
    public void executeVNPayTransaction(String txnId, double amount) {
        System.out.println("[VNPay Engine] Đã xử lý giao dịch ID: " + txnId + " | Số tiền: " + String.format("%,.0f", amount) + " VND");
    }
}

/**
 * Adapter Pattern: Lớp bọc VNPayToMoMoAdapter cài đặt giao diện MoMoPayable
 * nhưng ủy quyền thực thi cho đối tượng VNPayPayable bên dưới.
 */
public class VNPayToMoMoAdapter implements MoMoPayable {
    private final VNPayPayable vnpayService;

    public VNPayToMoMoAdapter(VNPayPayable vnpayService) {
        this.vnpayService = vnpayService;
    }

    @Override
    public void processMoMoPayment(double amountInVnd) {
        String generatedTxnId = "MOMO_ADAPT_" + System.currentTimeMillis();
        System.out.println("[Adapter] Đang chuyển đổi lời gọi MoMoPayment() -> VNPayTransaction()...");
        vnpayService.executeVNPayTransaction(generatedTxnId, amountInVnd);
    }
}


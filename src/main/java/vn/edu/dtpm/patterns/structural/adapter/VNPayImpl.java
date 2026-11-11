package vn.edu.dtpm.patterns.structural.adapter;

/**
 * Cài đặt cổng thanh toán VNPay thực tế.
 */
public class VNPayImpl implements VNPayPayable {
    @Override
    public void executeVNPayTransaction(String txnId, double amount) {
        System.out.println("[VNPay Engine] Đã xử lý giao dịch ID: " + txnId + " | Số tiền: " + String.format("%,.0f", amount) + " VND");
    }
}

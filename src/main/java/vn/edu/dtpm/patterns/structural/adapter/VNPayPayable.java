package vn.edu.dtpm.patterns.structural.adapter;

/**
 * Giao diện dịch vụ cổng thanh toán VNPay hiện tại của hệ thống.
 */
public interface VNPayPayable {
    void executeVNPayTransaction(String txnId, double amount);
}


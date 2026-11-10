package vn.edu.dtpm.patterns.structural.adapter;

/**
 * Giao diện mới mà đối tác / khách hàng yêu cầu tích hợp: Ví điện tử MoMo.
 */
public interface MoMoPayable {
    void processMoMoPayment(double amountInVnd);
}


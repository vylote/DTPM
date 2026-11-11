package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Receiver: Lớp tiếp nhận và thực thi logic nghiệp vụ phức tạp của ngân hàng.
 */
public class BankTransactionWorker {
    public void calculateInterest(String accountId, double balance, double annualRate) {
        double monthlyInterest = balance * (annualRate / 100.0) / 12.0;
        System.out.println(String.format(
            "   [Worker - Quyết toán lãi] Tài khoản VietinBank: %s | Số dư: %,.0f VNĐ | Lãi suất: %.1f%%/năm -> Tiền lãi ghi có: %,.0f VNĐ",
            accountId, balance, annualRate, monthlyInterest
        ));
    }

    public void exportStatement(String customerName, String monthYear) {
        System.out.println(String.format(
            "   [Worker - Sao kê tài khoản] Xuất file PDF chứng thực số dư điện tử cho khách hàng: %s (Kỳ: %s) -> Đã ký số bảo mật PKI CA.",
            customerName, monthYear
        ));
    }

    public void verifyEKYC(String cccd, String fullName) {
        System.out.println(String.format(
            "   [Worker - Định danh eKYC] Đối soát CCCD gắn chip: %s (%s) với Cơ sở dữ liệu Quốc gia về Dân cư -> XÁC THỰC THÀNH CÔNG.",
            cccd, fullName
        ));
    }
}

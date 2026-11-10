package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Command Interface: Đóng gói một yêu cầu công việc thành một đối tượng độc lập.
 */
public interface JobCommand {
    void execute();
    String getJobName();
}

/**
 * Receiver: Lớp tiếp nhận và thực thi logic nghiệp vụ phức tạp của ngân hàng.
 */
class BankTransactionWorker {
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

/**
 * Concrete Command 1: Tác vụ tính toán lãi tiết kiệm tự động.
 */
class InterestCalculationJob implements JobCommand {
    private final BankTransactionWorker worker;
    private final String accountId;
    private final double balance;
    private final double rate;

    public InterestCalculationJob(BankTransactionWorker worker, String accountId, double balance, double rate) {
        this.worker = worker;
        this.accountId = accountId;
        this.balance = balance;
        this.rate = rate;
    }

    @Override
    public String getJobName() {
        return "Quyết toán lãi tự động cho tài khoản: " + accountId;
    }

    @Override
    public void execute() {
        worker.calculateInterest(accountId, balance, rate);
    }
}

/**
 * Concrete Command 2: Tác vụ xuất sao kê giao dịch ngân hàng.
 */
class ExportStatementJob implements JobCommand {
    private final BankTransactionWorker worker;
    private final String customerName;
    private final String period;

    public ExportStatementJob(BankTransactionWorker worker, String customerName, String period) {
        this.worker = worker;
        this.customerName = customerName;
        this.period = period;
    }

    @Override
    public String getJobName() {
        return "Xuất sao kê giao dịch cho: " + customerName;
    }

    @Override
    public void execute() {
        worker.exportStatement(customerName, period);
    }
}

/**
 * Concrete Command 3: Tác vụ xác thực sinh trắc học định danh eKYC.
 */
class EKYCVerificationJob implements JobCommand {
    private final BankTransactionWorker worker;
    private final String cccd;
    private final String fullName;

    public EKYCVerificationJob(BankTransactionWorker worker, String cccd, String fullName) {
        this.worker = worker;
        this.cccd = cccd;
        this.fullName = fullName;
    }

    @Override
    public String getJobName() {
        return "Xác thực danh tính eKYC: " + fullName;
    }

    @Override
    public void execute() {
        worker.verifyEKYC(cccd, fullName);
    }
}

/**
 * Invoker: Quản lý hàng đợi tác vụ hệ thống (Thread Pool Task Queue).
 */
class ThreadPoolJobQueue {
    private final Queue<JobCommand> taskQueue = new LinkedList<>();

    public void submitJob(JobCommand job) {
        taskQueue.offer(job);
        System.out.println("[Queue] Đã đưa vào hàng đợi: [" + job.getJobName() + "]");
    }

    public void processAllJobs() {
        System.out.println("\n[ThreadPool] Bắt đầu phân phối và thực thi các tác vụ trong hàng đợi (" + taskQueue.size() + " tác vụ):\n");
        int count = 1;
        while (!taskQueue.isEmpty()) {
            JobCommand job = taskQueue.poll();
            System.out.println("Tác vụ #" + count + ": [" + job.getJobName() + "]");
            job.execute();
            count++;
        }
        System.out.println("\n[ThreadPool] -> TẤT CẢ TÁC VỤ ĐÃ ĐƯỢC THỰC THI HOÀN TẤT AN TOÀN!");
    }
}


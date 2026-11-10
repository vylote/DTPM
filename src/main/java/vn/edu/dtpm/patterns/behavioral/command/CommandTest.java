package vn.edu.dtpm.patterns.behavioral.command;

public class CommandTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ COMMAND PATTERN: HÀNG ĐỢI TÁC VỤ ---");
        System.out.println("==================================================");

        // 1. Khởi tạo đối tượng thực thi Receiver
        BankTransactionWorker bankWorker = new BankTransactionWorker();

        // 2. Khởi tạo Invoker hàng đợi
        ThreadPoolJobQueue jobQueue = new ThreadPoolJobQueue();

        // 3. Đóng gói các yêu cầu nghiệp vụ thành các Command độc lập
        System.out.println("1. Tiếp nhận và đẩy các tác vụ vào hàng đợi hệ thống:\n");
        jobQueue.submitJob(new InterestCalculationJob(bankWorker, "1028889999", 500_000_000.0, 6.5));
        jobQueue.submitJob(new EKYCVerificationJob(bankWorker, "001202008899", "Nguyễn Văn An"));
        jobQueue.submitJob(new ExportStatementJob(bankWorker, "Trần Thị Bình", "10/2026"));
        jobQueue.submitJob(new InterestCalculationJob(bankWorker, "1037776655", 1_200_000_000.0, 7.0));

        // 4. Kích hoạt xử lý hàng đợi
        jobQueue.processAllJobs();
    }
}


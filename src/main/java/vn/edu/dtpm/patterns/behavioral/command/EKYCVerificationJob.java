package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Concrete Command 3: Tác vụ xác thực sinh trắc học định danh eKYC.
 */
public class EKYCVerificationJob implements JobCommand {
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

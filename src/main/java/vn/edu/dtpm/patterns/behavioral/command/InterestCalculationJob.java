package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Concrete Command 1: Tác vụ tính toán lãi tiết kiệm tự động.
 */
public class InterestCalculationJob implements JobCommand {
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

package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Concrete Command 2: Tác vụ xuất sao kê giao dịch ngân hàng.
 */
public class ExportStatementJob implements JobCommand {
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

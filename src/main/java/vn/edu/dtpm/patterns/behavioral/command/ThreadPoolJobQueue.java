package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invoker: Quản lý hàng đợi tác vụ hệ thống (Thread Pool Task Queue).
 */
public class ThreadPoolJobQueue {
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

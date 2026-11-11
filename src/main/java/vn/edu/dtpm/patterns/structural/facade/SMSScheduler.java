package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class SMSScheduler {
    public void startScheduler() {
        System.out.println("[Subsystem - Scheduler] Bộ lập lịch tác vụ nền (Quartz Scheduler) bắt đầu chạy");
    }
    public void stopScheduler() {
        System.out.println("[Subsystem - Scheduler] Tạm dừng tất cả các tác vụ lập lịch");
    }
}

package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class MessageQueueManager {
    public void initQueue() {
        System.out.println("[Subsystem - Queue] Khởi tạo hàng đợi RabbitMQ/Kafka tin nhắn chờ gửi");
    }
    public void flushAndClose() {
        System.out.println("[Subsystem - Queue] Đẩy hết tin nhắn tồn đọng và đóng hàng đợi");
    }
}

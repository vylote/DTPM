package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

/**
 * Các hệ thống con (Subsystems) phức tạp của Máy chủ gửi tin nhắn Viettel Telecom.
 */
class ConfigurationReader {
    public void loadConfig() {
        System.out.println("[Subsystem - Config] Đọc tệp cấu hình viettel_sms_gateway.properties");
    }
}

class SecurityContextManager {
    public void authenticateGateway() {
        System.out.println("[Subsystem - Security] Xác thực chứng chỉ SSL/TLS và khóa bí mật Viettel CA");
    }
    public void revokeTokens() {
        System.out.println("[Subsystem - Security] Thu hồi toàn bộ Access Token của phiên làm việc");
    }
}

class DatabaseConnectionPool {
    public void initPool() {
        System.out.println("[Subsystem - DB] Khởi tạo kết nối Pool lưu trữ lịch sử tin nhắn SMS");
    }
    public void releasePool() {
        System.out.println("[Subsystem - DB] Đóng an toàn các kết nối CSDL Pool");
    }
}

class MessageQueueManager {
    public void initQueue() {
        System.out.println("[Subsystem - Queue] Khởi tạo hàng đợi RabbitMQ/Kafka tin nhắn chờ gửi");
    }
    public void flushAndClose() {
        System.out.println("[Subsystem - Queue] Đẩy hết tin nhắn tồn đọng và đóng hàng đợi");
    }
}

class TelecomBtsTransceiver {
    public void connectToBTS() {
        System.out.println("[Subsystem - BTS] Kết nối trạm phát sóng Viettel 4G/5G Base Transceiver Station");
    }
    public void disconnectBTS() {
        System.out.println("[Subsystem - BTS] Ngắt kết nối an toàn với trạm Viettel BTS");
    }
    public void transmit(String phone, String text) {
        System.out.println("   >>> [Viettel BTS SMS] Gửi tới: " + phone + " | Nội dung: \"" + text + "\"");
    }
}

class SMSScheduler {
    public void startScheduler() {
        System.out.println("[Subsystem - Scheduler] Bộ lập lịch tác vụ nền (Quartz Scheduler) bắt đầu chạy");
    }
    public void stopScheduler() {
        System.out.println("[Subsystem - Scheduler] Tạm dừng tất cả các tác vụ lập lịch");
    }
}

/**
 * Façade Class: Đơn giản hóa toàn bộ chuỗi khởi động và tắt máy chủ Viettel SMS.
 */
public class ScheduleServerFacade {
    private final ConfigurationReader configReader;
    private final SecurityContextManager securityManager;
    private final DatabaseConnectionPool dbPool;
    private final MessageQueueManager queueManager;
    private final TelecomBtsTransceiver btsTransceiver;
    private final SMSScheduler scheduler;

    public ScheduleServerFacade() {
        this.configReader = new ConfigurationReader();
        this.securityManager = new SecurityContextManager();
        this.dbPool = new DatabaseConnectionPool();
        this.queueManager = new MessageQueueManager();
        this.btsTransceiver = new TelecomBtsTransceiver();
        this.scheduler = new SMSScheduler();
    }

    /**
     * Khởi động máy chủ trọn gói chỉ với 1 lời gọi duy nhất.
     */
    public void startServer() {
        System.out.println("[Façade] Bắt đầu quy trình khởi động Máy chủ Tin nhắn Viettel...");
        configReader.loadConfig();
        securityManager.authenticateGateway();
        dbPool.initPool();
        queueManager.initQueue();
        btsTransceiver.connectToBTS();
        scheduler.startScheduler();
        System.out.println("[Façade] -> MÁY CHỦ VIETTEL SMS ĐÃ SẴN SÀNG HOẠT ĐỘNG 100%!\n");
    }

    /**
     * Gửi tin nhắn hàng loạt theo chiến dịch.
     */
    public void sendCampaignSMS(String campaignTitle, String content, List<String> phoneNumbers) {
        System.out.println("[Façade] Triển khai chiến dịch: " + campaignTitle);
        for (String phone : phoneNumbers) {
            btsTransceiver.transmit(phone, content);
        }
        System.out.println("[Façade] Đã chuyển tin nhắn vào hàng đợi phát sóng Viettel thành công!\n");
    }

    /**
     * Tắt máy chủ tuần tự theo đúng quy chuẩn an toàn.
     */
    public void stopServer() {
        System.out.println("[Façade] Bắt đầu quy trình tắt an toàn Máy chủ Tin nhắn Viettel...");
        scheduler.stopScheduler();
        queueManager.flushAndClose();
        btsTransceiver.disconnectBTS();
        dbPool.releasePool();
        securityManager.revokeTokens();
        System.out.println("[Façade] -> TOÀN BỘ MÁY CHỦ VIETTEL SMS ĐÃ DỪNG HOẠT ĐỘNG AN TOÀN!");
    }
}


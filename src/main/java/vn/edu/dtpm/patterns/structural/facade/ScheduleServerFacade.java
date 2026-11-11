package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

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

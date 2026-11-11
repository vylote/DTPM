package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

/**
 * Các hệ thống con (Subsystems) phức tạp của Máy chủ gửi tin nhắn Viettel Telecom.
 */
public class ConfigurationReader {
    public void loadConfig() {
        System.out.println("[Subsystem - Config] Đọc tệp cấu hình viettel_sms_gateway.properties");
    }
}

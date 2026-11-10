package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class FacadeTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ FAÇADE PATTERN: MÁY CHỦ SMS VIETTEL ---");
        System.out.println("==================================================");

        ScheduleServerFacade serverFacade = new ScheduleServerFacade();

        // 1. Khởi động toàn bộ máy chủ phức tạp thông qua giao diện Facade tiện lợi
        serverFacade.startServer();

        // 2. Thực thi gửi tin nhắn thông báo chăm sóc khách hàng Viettel
        List<String> customerPhones = List.of("0988123456", "0977889900", "0966554433");
        serverFacade.sendCampaignSMS(
                "Khuyến mãi Data 5G ViettelPay",
                "Viettel tang ban 10GB Data 5G trai nghiem ung dung Viettel Money dip cuoi tuan!",
                customerPhones
        );

        // 3. Tắt máy chủ chỉ bằng 1 phương thức duy nhất
        serverFacade.stopServer();
    }
}


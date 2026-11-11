package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class TelecomBtsTransceiver {
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

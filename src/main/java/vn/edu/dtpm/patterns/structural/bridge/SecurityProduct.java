package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Implementor Interface: Định nghĩa giao diện hệ thống an ninh độc lập với loại phương tiện.
 */
public interface SecurityProduct {
    void armSystem();
    void disarmSystem();
    void triggerAlarm();
    void locateGPS();
    String getSystemName();
}

/**
 * Concrete Implementor 1: Hệ thống an ninh thông minh VinFast Smart Security.
 */
class VinFastSmartSecurity implements SecurityProduct {
    @Override
    public String getSystemName() {
        return "VinFast Smart Security OS (Định vị Viettel 5G & Nhận diện khuôn mặt)";
    }

    @Override
    public void armSystem() {
        System.out.println("   [VinFast Security] Đã kích hoạt hệ thống bảo vệ từ xa qua VinFast App trên điện thoại.");
    }

    @Override
    public void disarmSystem() {
        System.out.println("   [VinFast Security] Đã mở khóa bảo vệ bằng khuôn mặt chủ xe và NFC Smart Key.");
    }

    @Override
    public void triggerAlarm() {
        System.out.println("   [VinFast Security] CẢNH BÁO: Phát hiện rung chấn bất thường! Đang nháy đèn LED và gửi cảnh báo khẩn cấp tới điện thoại.");
    }

    @Override
    public void locateGPS() {
        System.out.println("   [VinFast Security] Tọa độ GPS Viettel: 21.0285° N, 105.8542° E (Trụ sở VinFast Smart City, Hà Nội).");
    }
}

/**
 * Concrete Implementor 2: Hệ thống an toàn Toyota Safety Sense.
 */
class ToyotaSafetySense implements SecurityProduct {
    @Override
    public String getSystemName() {
        return "Toyota Safety Sense TSS-3 (Cảm biến sóng âm Radar & Chống trộm Immobilizer)";
    }

    @Override
    public void armSystem() {
        System.out.println("   [Toyota TSS] Đã kích hoạt khóa động cơ chống trộm Immobilizer và cảm biến siêu âm trong xe.");
    }

    @Override
    public void disarmSystem() {
        System.out.println("   [Toyota TSS] Nhận diện chìa khóa thông minh Toyota SmartKey, vô hiệu hóa còi báo động.");
    }

    @Override
    public void triggerAlarm() {
        System.out.println("   [Toyota TSS] CẢNH BÁO: Kính xe bị tác động lực mạnh! Còi báo động công suất lớn 120dB đang hú.");
    }

    @Override
    public void locateGPS() {
        System.out.println("   [Toyota TSS] Tọa độ GPS Toyota Connect: 10.7769° N, 106.7009° E (Đại lý Toyota Bến Thành, TP.HCM).");
    }
}


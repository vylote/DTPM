package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Concrete Implementor 1: Hệ thống an ninh thông minh VinFast Smart Security.
 */
public class VinFastSmartSecurity implements SecurityProduct {
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

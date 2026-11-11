package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Concrete Implementor 2: Hệ thống an toàn Toyota Safety Sense.
 */
public class ToyotaSafetySense implements SecurityProduct {
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

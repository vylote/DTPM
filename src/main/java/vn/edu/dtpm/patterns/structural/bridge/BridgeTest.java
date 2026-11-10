package vn.edu.dtpm.patterns.structural.bridge;

public class BridgeTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ BRIDGE PATTERN: AN NINH PHƯƠNG TIỆN ---");
        System.out.println("==================================================");

        // 1. Khởi tạo 2 hệ thống an ninh độc lập
        SecurityProduct vinfastSecurity = new VinFastSmartSecurity();
        SecurityProduct toyotaSecurity = new ToyotaSafetySense();

        // 2. Ô tô điện VinFast VF8 tích hợp hệ thống an ninh gốc VinFast Security
        System.out.println("1. Cấu hình Ô tô VinFast VF8 sử dụng VinFast Smart Security:");
        Vehicle vf8 = new ElectricCar(vinfastSecurity, "VinFast VF8 SUV");
        vf8.lockVehicle();
        vf8.handleSuspiciousActivity();
        vf8.unlockVehicle();

        // 3. Ô tô Toyota Camry tích hợp hệ thống Toyota Safety Sense
        System.out.println("\n2. Cấu hình Xe Toyota Camry sử dụng Toyota Safety Sense:");
        Vehicle camry = new ElectricCar(toyotaSecurity, "Toyota Camry Hybrid");
        camry.lockVehicle();
        camry.handleSuspiciousActivity();
        camry.unlockVehicle();

        // 4. Nhờ mẫu Bridge: Xe máy điện VinFast Klara S có thể ghép nối linh hoạt với bất kỳ hệ thống an ninh nào
        System.out.println("\n3. Ghép nối linh hoạt: Xe máy điện VinFast Klara S với hệ thống Toyota Safety Sense:");
        Vehicle klara = new ElectricScooter(toyotaSecurity, "VinFast Klara S");
        klara.lockVehicle();
        klara.handleSuspiciousActivity();
    }
}


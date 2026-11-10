package vn.edu.dtpm.patterns.creational.builder;

public class BuilderTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ BUILDER PATTERN: CẤU HÌNH XE VINFAST ---");
        System.out.println("==================================================");

        VinFastDirector director = new VinFastDirector();

        // 1. Dùng Director đóng gói mẫu VF8 Plus
        CarBuilder builder1 = new VinFastCarConcreteBuilder();
        VinFastCar vf8 = director.constructVF8Plus(builder1);
        System.out.println(vf8);

        // 2. Dùng Director đóng gói mẫu VF9 Executive
        CarBuilder builder2 = new VinFastCarConcreteBuilder();
        VinFastCar vf9 = director.constructVF9Executive(builder2);
        System.out.println(vf9);

        // 3. Khách hàng tự do tùy biến cấu hình theo sở thích cá nhân (Custom Order)
        System.out.println("\n3. Khách hàng VIP tùy biến cấu hình cá nhân hóa:");
        CarBuilder customBuilder = new VinFastCarConcreteBuilder();
        VinFastCar customCar = customBuilder
                .setModel("VinFast VF Wild - Bản giới thiệu Concept")
                .setCarType("Bán tải điện địa hình Sport")
                .setEngineType("Điện 3 Motor Tri-Motor Offroad")
                .setBatteryCapacity("Pin thể rắn LFP 130 kWh")
                .setColor("Xám Bạc Kim Loại (Desat Silver)")
                .setInterior("Nội thất Alcantara thể thao chống nước")
                .setAutopilot(true)
                .setPanoramicSunroof(true)
                .setSeats(5)
                .setPriceVnd(1_890_000_000.0)
                .build();
        System.out.println(customCar);
    }
}


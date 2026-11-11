package vn.edu.dtpm.patterns.creational.builder;

/**
 * Director: Người chỉ đạo quy trình tạo ra các phiên bản xe mẫu định sẵn.
 */
public class VinFastDirector {
    public VinFastCar constructVF8Plus(CarBuilder builder) {
        return builder.setModel("VinFast VF8 Plus")
                .setCarType("D-SUV Thể thao")
                .setEngineType("Điện 2 Motor AWD (402 HP)")
                .setBatteryCapacity("Pin CATL 87.7 kWh (Tầm vận hành 471 km)")
                .setColor("Đỏ Thẫm (Crimson Red)")
                .setInterior("Da Nappa Nâu Saddle")
                .setAutopilot(true)
                .setPanoramicSunroof(true)
                .setSeats(5)
                .setPriceVnd(1_270_000_000.0)
                .build();
    }

    public VinFastCar constructVF9Executive(CarBuilder builder) {
        return builder.setModel("VinFast VF9 President Executive")
                .setCarType("E-SUV Cỡ lớn Hạng sang")
                .setEngineType("Điện kép Dual-Motor (402 HP, 620 Nm)")
                .setBatteryCapacity("Pin CATL 123 kWh (Tầm vận hành 626 km)")
                .setColor("Xanh Dương Sâu (Deep Ocean Blue)")
                .setInterior("Da Nappa Be thượng hạng với ghế Cơ trưởng có massage")
                .setAutopilot(true)
                .setPanoramicSunroof(true)
                .setSeats(6)
                .setPriceVnd(2_169_000_000.0)
                .build();
    }

    public VinFastCar constructLuxA2Sedan(CarBuilder builder) {
        return builder.setModel("VinFast Lux A2.0 Premium")
                .setCarType("Sedan Thể thao")
                .setEngineType("Xăng 2.0L Turbo DOHC BMW N20 (228 HP)")
                .setBatteryCapacity("Ắc quy khởi động AGM")
                .setColor("Đen Huyền Bí (Jet Black)")
                .setInterior("Da Nappa Cao Cấp Nâu")
                .setAutopilot(false)
                .setPanoramicSunroof(false)
                .setSeats(5)
                .setPriceVnd(980_000_000.0)
                .build();
    }
}

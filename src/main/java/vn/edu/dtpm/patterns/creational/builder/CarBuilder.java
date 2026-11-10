package vn.edu.dtpm.patterns.creational.builder;

/**
 * Interface Builder xác định các bước lắp ráp cấu hình xe VinFast.
 */
public interface CarBuilder {
    CarBuilder setModel(String model);
    CarBuilder setCarType(String carType);
    CarBuilder setEngineType(String engineType);
    CarBuilder setBatteryCapacity(String batteryCapacity);
    CarBuilder setColor(String color);
    CarBuilder setInterior(String interior);
    CarBuilder setAutopilot(boolean autopilot);
    CarBuilder setPanoramicSunroof(boolean panoramicSunroof);
    CarBuilder setSeats(int seats);
    CarBuilder setPriceVnd(double priceVnd);
    VinFastCar build();
}

/**
 * Concrete Builder cài đặt chi tiết từng bước xây dựng xe VinFast.
 */
class VinFastCarConcreteBuilder implements CarBuilder {
    private String model = "VinFast VF tiêu chuẩn";
    private String carType = "Sedan";
    private String engineType = "Thuần điện (Dual Motor AWD)";
    private String batteryCapacity = "CATL 87.7 kWh";
    private String color = "Trắng ngọc trai (Brahminy White)";
    private String interior = "Da nhân tạo đen";
    private boolean autopilot = false;
    private boolean panoramicSunroof = false;
    private int seats = 5;
    private double priceVnd = 1_000_000_000.0;

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    @Override
    public CarBuilder setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    @Override
    public CarBuilder setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder setInterior(String interior) {
        this.interior = interior;
        return this;
    }

    @Override
    public CarBuilder setAutopilot(boolean autopilot) {
        this.autopilot = autopilot;
        return this;
    }

    @Override
    public CarBuilder setPanoramicSunroof(boolean panoramicSunroof) {
        this.panoramicSunroof = panoramicSunroof;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public CarBuilder setPriceVnd(double priceVnd) {
        this.priceVnd = priceVnd;
        return this;
    }

    @Override
    public VinFastCar build() {
        return new VinFastCar(
            model, carType, engineType, batteryCapacity,
            color, interior, autopilot, panoramicSunroof,
            seats, priceVnd
        );
    }
}

/**
 * Director: Người chỉ đạo quy trình tạo ra các phiên bản xe mẫu định sẵn.
 */
class VinFastDirector {
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


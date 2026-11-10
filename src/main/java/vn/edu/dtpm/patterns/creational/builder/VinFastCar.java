package vn.edu.dtpm.patterns.creational.builder;

/**
 * Product: Đối tượng xe ô tô VinFast với nhiều tùy chọn cấu hình phức tạp.
 */
public class VinFastCar {
    private final String model;
    private final String carType; // Sedan, SUV, Sport
    private final String engineType; // Thuần điện (EV), Xăng tăng áp
    private final String batteryCapacity; // Pin CATL 87.7 kWh, 123 kWh
    private final String color;
    private final String interior; // Da Nappa, Da tổng hợp cao cấp
    private final boolean autopilot; // ADAS cấp độ 2/3
    private final boolean panoramicSunroof; // Cửa sổ trời toàn cảnh
    private final int seats;
    private final double priceVnd;

    // Package-private constructor, chỉ được khởi tạo qua CarBuilder
    VinFastCar(String model, String carType, String engineType, String batteryCapacity,
               String color, String interior, boolean autopilot, boolean panoramicSunroof,
               int seats, double priceVnd) {
        this.model = model;
        this.carType = carType;
        this.engineType = engineType;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
        this.interior = interior;
        this.autopilot = autopilot;
        this.panoramicSunroof = panoramicSunroof;
        this.seats = seats;
        this.priceVnd = priceVnd;
    }

    public String getModel() { return model; }
    public String getCarType() { return carType; }
    public String getEngineType() { return engineType; }
    public String getBatteryCapacity() { return batteryCapacity; }
    public String getColor() { return color; }
    public String getInterior() { return interior; }
    public boolean hasAutopilot() { return autopilot; }
    public boolean hasPanoramicSunroof() { return panoramicSunroof; }
    public int getSeats() { return seats; }
    public double getPriceVnd() { return priceVnd; }

    @Override
    public String toString() {
        return String.format(
            "==========================================================\n" +
            "  VINFAST AUTOMOBILE SPECIFICATION: %s (%s)\n" +
            "----------------------------------------------------------\n" +
            "  * Động cơ: %s | Pin: %s\n" +
            "  * Ngoại thất màu: %s | Nội thất: %s\n" +
            "  * Số chỗ ngồi: %d chỗ | Cửa sổ trời: %s\n" +
            "  * Tự hành thông minh (ADAS): %s\n" +
            "  * Giá niêm yết: %,.0f VNĐ\n" +
            "==========================================================",
            model, carType, engineType, batteryCapacity, color, interior,
            seats, (panoramicSunroof ? "Có (Panorama)" : "Không"),
            (autopilot ? "Hỗ trợ lái nâng cao ADAS Level 2+" : "Tiêu chuẩn"), priceVnd
        );
    }
}


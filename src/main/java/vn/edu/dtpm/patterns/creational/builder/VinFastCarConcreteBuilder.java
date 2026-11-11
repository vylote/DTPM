package vn.edu.dtpm.patterns.creational.builder;

/**
 * Concrete Builder cài đặt chi tiết từng bước xây dựng xe VinFast.
 */
public class VinFastCarConcreteBuilder implements CarBuilder {
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

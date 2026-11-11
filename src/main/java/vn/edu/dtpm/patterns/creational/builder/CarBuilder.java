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

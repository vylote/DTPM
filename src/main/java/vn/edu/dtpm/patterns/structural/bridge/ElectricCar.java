package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Refined Abstraction 1: Dòng xe ô tô điện thông minh.
 */
public class ElectricCar extends Vehicle {
    public ElectricCar(SecurityProduct securitySystem, String vehicleModel) {
        super(securitySystem, vehicleModel);
    }

    @Override
    public void lockVehicle() {
        System.out.println("\n[Ô tô điện " + vehicleModel + "] Đóng cửa tự động, gập gương điện:");
        securitySystem.armSystem();
    }

    @Override
    public void unlockVehicle() {
        System.out.println("\n[Ô tô điện " + vehicleModel + "] Mở cửa thông minh:");
        securitySystem.disarmSystem();
    }

    @Override
    public void handleSuspiciousActivity() {
        System.out.println("\n[Ô tô điện " + vehicleModel + "] Kích hoạt hệ thống phòng thủ:");
        securitySystem.triggerAlarm();
        securitySystem.locateGPS();
    }
}

package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Abstraction: Lớp trừu tượng đại diện cho các phương tiện giao thông.
 * Cầu nối (Bridge) được duy trì qua tham chiếu tới SecurityProduct.
 */
public abstract class Vehicle {
    protected SecurityProduct securitySystem;
    protected String vehicleModel;

    public Vehicle(SecurityProduct securitySystem, String vehicleModel) {
        this.securitySystem = securitySystem;
        this.vehicleModel = vehicleModel;
    }

    public void setSecuritySystem(SecurityProduct securitySystem) {
        this.securitySystem = securitySystem;
    }

    public abstract void lockVehicle();
    public abstract void unlockVehicle();
    public abstract void handleSuspiciousActivity();
}

/**
 * Refined Abstraction 1: Dòng xe ô tô điện thông minh.
 */
class ElectricCar extends Vehicle {
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

/**
 * Refined Abstraction 2: Dòng xe máy điện thông minh.
 */
class ElectricScooter extends Vehicle {
    public ElectricScooter(SecurityProduct securitySystem, String vehicleModel) {
        super(securitySystem, vehicleModel);
    }

    @Override
    public void lockVehicle() {
        System.out.println("\n[Xe máy điện " + vehicleModel + "] Khóa cổ xe điện tử:");
        securitySystem.armSystem();
    }

    @Override
    public void unlockVehicle() {
        System.out.println("\n[Xe máy điện " + vehicleModel + "] Mở khóa xe máy:");
        securitySystem.disarmSystem();
    }

    @Override
    public void handleSuspiciousActivity() {
        System.out.println("\n[Xe máy điện " + vehicleModel + "] Phát hiện bị dắt trộm:");
        securitySystem.triggerAlarm();
        securitySystem.locateGPS();
    }
}


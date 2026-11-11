package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Refined Abstraction 2: Dòng xe máy điện thông minh.
 */
public class ElectricScooter extends Vehicle {
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

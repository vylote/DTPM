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

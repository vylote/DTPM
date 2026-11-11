package vn.edu.dtpm.patterns.structural.bridge;

/**
 * Implementor Interface: Định nghĩa giao diện hệ thống an ninh độc lập với loại phương tiện.
 */
public interface SecurityProduct {
    void armSystem();
    void disarmSystem();
    void triggerAlarm();
    void locateGPS();
    String getSystemName();
}

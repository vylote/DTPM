package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Giao diện Product: Bộ phân tích đơn hàng từ sàn thương mại điện tử.
 */
public interface OrderParser {
    String parseOrder(String xmlData);
    String getPlatformName();
}

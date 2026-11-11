package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Concrete Product 1: Phân tích đơn hàng XML từ Tiki.
 */
public class TikiOrderParser implements OrderParser {
    @Override
    public String getPlatformName() {
        return "Tiki Việt Nam";
    }

    @Override
    public String parseOrder(String xmlData) {
        // Giả lập bóc tách XML đơn hàng Tiki
        System.out.println("[TikiParser] Đang phân tích cú pháp gói XML Tiki: " + xmlData);
        String orderId = extractTag(xmlData, "id", "TIKI-DEFAULT-001");
        String customer = extractTag(xmlData, "customer", "Khách hàng Tiki");
        String shipping = extractTag(xmlData, "shipping", "TikiNow Giao Siêu Tốc 2h");
        String total = extractTag(xmlData, "total", "0");

        return String.format("-> [ĐƠN HÀNG TIKI HỢP LỆ] Mã: %s | Người nhận: %s | Hình thức: %s | Tổng tiền: %s VNĐ",
                orderId, customer, shipping, total);
    }

    private String extractTag(String xml, String tag, String defaultValue) {
        String open = "<" + tag + ">";
        String close = "</" + tag + ">";
        int start = xml.indexOf(open);
        int end = xml.indexOf(close);
        if (start != -1 && end != -1) {
            return xml.substring(start + open.length(), end);
        }
        return defaultValue;
    }
}

package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Concrete Product 2: Phân tích đơn hàng XML từ Shopee.
 */
public class ShopeeOrderParser implements OrderParser {
    @Override
    public String getPlatformName() {
        return "Shopee Việt Nam";
    }

    @Override
    public String parseOrder(String xmlData) {
        // Giả lập bóc tách XML đơn hàng Shopee
        System.out.println("[ShopeeParser] Đang phân tích cú pháp gói XML Shopee: " + xmlData);
        String orderId = extractTag(xmlData, "orderId", "SP-VN-8888");
        String buyer = extractTag(xmlData, "buyer", "Khách hàng Shopee");
        String voucher = extractTag(xmlData, "voucher", "Mã Giảm Giá Xtra");
        String coins = extractTag(xmlData, "coinsUsed", "0");
        String amount = extractTag(xmlData, "amount", "0");

        return String.format("-> [ĐƠN HÀNG SHOPEE HỢP LỆ] Mã: %s | Người mua: %s | Voucher: %s | Dùng Xu: %s | Thanh toán: %s VNĐ",
                orderId, buyer, voucher, coins, amount);
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

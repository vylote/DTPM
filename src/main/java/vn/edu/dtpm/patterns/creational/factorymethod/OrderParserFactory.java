package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Creator trừu tượng: Định nghĩa Factory Method tạo OrderParser.
 */
public abstract class OrderParserFactory {

    // Factory Method được các lớp con ghi đè
    public abstract OrderParser createParser();

    // Nghiệp vụ cốt lõi sử dụng Factory Method
    public void processOrder(String xmlData) {
        System.out.println("\n[OrderParserFactory] Bắt đầu quy trình tiếp nhận đơn hàng...");
        OrderParser parser = createParser();
        System.out.println("[OrderParserFactory] Đã khởi tạo Parser chuyên biệt cho: " + parser.getPlatformName());
        String result = parser.parseOrder(xmlData);
        System.out.println(result);
        System.out.println("[OrderParserFactory] Đã lưu thông tin đơn hàng vào hệ thống kế toán thành công!");
    }
}

/**
 * Concrete Creator 1: Factory tạo Tiki Parser
 */
class TikiOrderParserFactory extends OrderParserFactory {
    @Override
    public OrderParser createParser() {
        return new TikiOrderParser();
    }
}

/**
 * Concrete Creator 2: Factory tạo Shopee Parser
 */
class ShopeeOrderParserFactory extends OrderParserFactory {
    @Override
    public OrderParser createParser() {
        return new ShopeeOrderParser();
    }
}


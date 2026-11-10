package vn.edu.dtpm.patterns.creational.factorymethod;

public class FactoryMethodTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ FACTORY METHOD: TIKI / SHOPEE PARSER ---");
        System.out.println("==================================================");

        // 1. Dữ liệu XML giả lập từ Tiki
        String tikiXml = "<TikiOrder><id>TIKI-2026-9988</id><customer>Nguyễn Hoàng Nam (Hà Nội)</customer><shipping>TikiNow Siêu Tốc 2 Giờ</shipping><total>680000</total></TikiOrder>";

        // 2. Dữ liệu XML giả lập từ Shopee
        String shopeeXml = "<ShopeeOrder><orderId>SHOPEE-VN-7749</orderId><buyer>Lê Thị Mai (TP. Hồ Chí Minh)</buyer><voucher>GIAM50K_FREESHIP</voucher><coinsUsed>15000</coinsUsed><amount>420000</amount></ShopeeOrder>";

        // 3. Khởi tạo Factory xử lý Tiki
        OrderParserFactory tikiFactory = new TikiOrderParserFactory();
        tikiFactory.processOrder(tikiXml);

        // 4. Khởi tạo Factory xử lý Shopee
        OrderParserFactory shopeeFactory = new ShopeeOrderParserFactory();
        shopeeFactory.processOrder(shopeeXml);
    }
}


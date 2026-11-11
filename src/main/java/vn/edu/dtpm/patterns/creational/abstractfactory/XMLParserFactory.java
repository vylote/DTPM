package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Giao diện Abstract Factory: Tạo họ các Parser tương thích theo từng đối tác / chi nhánh.
 */
public interface XMLParserFactory {
    OrderXMLParser createOrderParser();
    FeedbackXMLParser createFeedbackParser();
    String getFactoryRegion();
    ShippingXMLParser createShippingParser();
}

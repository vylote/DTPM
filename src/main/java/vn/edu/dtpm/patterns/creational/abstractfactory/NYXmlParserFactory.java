package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Giao diện Product A: Parser đơn hàng quốc tế.
 */
interface OrderXMLParser {
    String parseOrderXML(String xml);
}

/**
 * Giao diện Product B: Parser phản hồi / đánh giá khách hàng quốc tế.
 */
interface FeedbackXMLParser {
    String parseFeedbackXML(String xml);
}

interface ShippingXMLParser{
    String parseShippingXML(String xml);
}

/**
 * Giao diện Abstract Factory: Tạo họ các Parser tương thích theo từng đối tác / chi nhánh.
 */
interface XMLParserFactory {
    OrderXMLParser createOrderParser();
    FeedbackXMLParser createFeedbackParser();
    String getFactoryRegion();
    ShippingXMLParser createShippingParser();
}

/**
 * Concrete Product A1: NY (New York / Đối tác Bắc Mỹ) Order Parser
 */
class NYOrderXMLParser implements OrderXMLParser {
    @Override
    public String parseOrderXML(String xml) {
        return "[NY Order Parser] Chuẩn hóa đơn hàng đối tác NY theo chuẩn ANSI XML: " + xml;
    }
}

/**
 * Concrete Product B1: NY Feedback Parser
 */
class NYFeedbackXMLParser implements FeedbackXMLParser {
    @Override
    public String parseFeedbackXML(String xml) {
        return "[NY Feedback Parser] Ghi nhận đánh giá người dùng khu vực NY (Định dạng UTF-8 / Star Rating): " + xml;
    }
}

class NYShippingXMLParser implements ShippingXMLParser{
    @Override
    public String parseShippingXML(String xml) {
        return "[NY Shipping Parser] Chuan hoa kieu van chuyen "+xml;
    }
}

/**
 * Concrete Factory 1: Xây dựng họ parser cho đối tác New York (NY)
 */
public class NYXmlParserFactory implements XMLParserFactory {
    @Override
    public String getFactoryRegion() {
        return "New York (Bắc Mỹ) / Chi nhánh Quốc tế";
    }

    @Override
    public OrderXMLParser createOrderParser() {
        return new NYOrderXMLParser();
    }

    @Override
    public FeedbackXMLParser createFeedbackParser() {
        return new NYFeedbackXMLParser();
    }
    
    @Override
    public ShippingXMLParser createShippingParser() {
        return new NYShippingXMLParser();
    }
}



package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Concrete Product A2: TW (Taiwan / Đối tác Châu Á - Đài Loan / Hàn Quốc) Order Parser
 */
class TWOrderXMLParser implements OrderXMLParser {
    @Override
    public String parseOrderXML(String xml) {
        return "[TW Order Parser] Chuẩn hóa đơn hàng đối tác TW/Châu Á theo chuẩn Big5 XML: " + xml;
    }
}

/**
 * Concrete Product B2: TW Feedback Parser
 */
class TWFeedbackXMLParser implements FeedbackXMLParser {
    @Override
    public String parseFeedbackXML(String xml) {
        return "[TW Feedback Parser] Ghi nhận đánh giá đối tác TW/Châu Á (Hỗ trợ đa ngôn ngữ CJK): " + xml;
    }
}

class TWShippingXMLParser implements ShippingXMLParser {
    @Override
    public String parseShippingXML(String xml) {
        return "[TW Shipping Parser] Chuẩn hóa vận chuyển quốc tế Đài Loan: " + xml;
    }
}

/**
 * Concrete Factory 2: Xây dựng họ parser cho đối tác Taiwan (TW) / Châu Á
 */
public class TWXmlParserFactory implements XMLParserFactory {
    @Override
    public String getFactoryRegion() {
        return "Taiwan / Đối tác Đông Bắc Á";
    }

    @Override
    public OrderXMLParser createOrderParser() {
        return new TWOrderXMLParser();
    }

    @Override
    public FeedbackXMLParser createFeedbackParser() {
        return new TWFeedbackXMLParser();
    }
    
    @Override
    public ShippingXMLParser createShippingParser() {
        return new TWShippingXMLParser();
    }
}


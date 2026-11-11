package vn.edu.dtpm.patterns.creational.abstractfactory;

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

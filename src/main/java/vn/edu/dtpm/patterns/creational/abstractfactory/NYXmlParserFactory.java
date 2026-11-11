package vn.edu.dtpm.patterns.creational.abstractfactory;

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

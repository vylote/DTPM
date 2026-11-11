package vn.edu.dtpm.patterns.creational.abstractfactory;

public class NYShippingXMLParser implements ShippingXMLParser{
    @Override
    public String parseShippingXML(String xml) {
        return "[NY Shipping Parser] Chuan hoa kieu van chuyen "+xml;
    }
}

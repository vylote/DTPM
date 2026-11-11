package vn.edu.dtpm.patterns.creational.abstractfactory;

public class TWShippingXMLParser implements ShippingXMLParser {
    @Override
    public String parseShippingXML(String xml) {
        return "[TW Shipping Parser] Chuẩn hóa vận chuyển quốc tế Đài Loan: " + xml;
    }
}

package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Concrete Product A2: TW (Taiwan / Đối tác Châu Á - Đài Loan / Hàn Quốc) Order Parser
 */
public class TWOrderXMLParser implements OrderXMLParser {
    @Override
    public String parseOrderXML(String xml) {
        return "[TW Order Parser] Chuẩn hóa đơn hàng đối tác TW/Châu Á theo chuẩn Big5 XML: " + xml;
    }
}

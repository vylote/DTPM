package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Concrete Product A1: NY (New York / Đối tác Bắc Mỹ) Order Parser
 */
public class NYOrderXMLParser implements OrderXMLParser {
    @Override
    public String parseOrderXML(String xml) {
        return "[NY Order Parser] Chuẩn hóa đơn hàng đối tác NY theo chuẩn ANSI XML: " + xml;
    }
}

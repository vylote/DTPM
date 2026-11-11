package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Giao diện Product A: Parser đơn hàng quốc tế.
 */
public interface OrderXMLParser {
    String parseOrderXML(String xml);
}

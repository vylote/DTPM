package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Giao diện Product B: Parser phản hồi / đánh giá khách hàng quốc tế.
 */
public interface FeedbackXMLParser {
    String parseFeedbackXML(String xml);
}

package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Concrete Product B1: NY Feedback Parser
 */
public class NYFeedbackXMLParser implements FeedbackXMLParser {
    @Override
    public String parseFeedbackXML(String xml) {
        return "[NY Feedback Parser] Ghi nhận đánh giá người dùng khu vực NY (Định dạng UTF-8 / Star Rating): " + xml;
    }
}

package vn.edu.dtpm.patterns.creational.abstractfactory;

/**
 * Concrete Product B2: TW Feedback Parser
 */
public class TWFeedbackXMLParser implements FeedbackXMLParser {
    @Override
    public String parseFeedbackXML(String xml) {
        return "[TW Feedback Parser] Ghi nhận đánh giá đối tác TW/Châu Á (Hỗ trợ đa ngôn ngữ CJK): " + xml;
    }
}

package vn.edu.dtpm.patterns.creational.abstractfactory;

public class AbstractFactoryTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ ABSTRACT FACTORY: HỆ THỐNG XML QUỐC TẾ ---");
        System.out.println("==================================================");

        // 1. Kiểm thử với nhà máy NY Factory
        System.out.println("1. Tích hợp họ Parser cho đối tác New York (NY):");
        XMLParserFactory nyFactory = new NYXmlParserFactory();
        System.out.println("   Khu vực áp dụng: " + nyFactory.getFactoryRegion());
        OrderXMLParser nyOrderParser = nyFactory.createOrderParser();
        FeedbackXMLParser nyFeedbackParser = nyFactory.createFeedbackParser();

        System.out.println("   " + nyOrderParser.parseOrderXML("<NYOrder><id>NY-9021</id><amt>$1200</amt></NYOrder>"));
        System.out.println("   " + nyFeedbackParser.parseFeedbackXML("<NYFeedback><user>JohnDoe</user><rating>5</rating></NYFeedback>"));

        // 2. Kiểm thử với nhà máy TW Factory
        System.out.println("\n2. Tích hợp họ Parser cho đối tác Taiwan (TW) / Châu Á:");
        XMLParserFactory twFactory = new TWXmlParserFactory();
        System.out.println("   Khu vực áp dụng: " + twFactory.getFactoryRegion());
        OrderXMLParser twOrderParser = twFactory.createOrderParser();
        FeedbackXMLParser twFeedbackParser = twFactory.createFeedbackParser();

        System.out.println("   " + twOrderParser.parseOrderXML("<TWOrder><id>TW-3011</id><amt>NT$35000</amt></TWOrder>"));
        System.out.println("   " + twFeedbackParser.parseFeedbackXML("<TWFeedback><user>ChenWei</user><rating>5</rating></TWFeedback>"));
    }
}


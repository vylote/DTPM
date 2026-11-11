package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Concrete Creator 1: Factory tạo Tiki Parser
 */
public class TikiOrderParserFactory extends OrderParserFactory {
    @Override
    public OrderParser createParser() {
        return new TikiOrderParser();
    }
}

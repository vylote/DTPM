package vn.edu.dtpm.patterns.creational.factorymethod;

/**
 * Concrete Creator 2: Factory tạo Shopee Parser
 */
public class ShopeeOrderParserFactory extends OrderParserFactory {
    @Override
    public OrderParser createParser() {
        return new ShopeeOrderParser();
    }
}

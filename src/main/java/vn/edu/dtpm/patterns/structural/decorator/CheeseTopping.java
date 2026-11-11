package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Concrete Decorator 1: Thêm Phô Mai Mozzarella béo ngậy.
 */
public class CheeseTopping extends PizzaToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Thêm Phô Mai Mozzarella Kéo Sợi";
    }

    @Override
    public double getCost() {
        return super.getCost() + 35_000.0;
    }
}

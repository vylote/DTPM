package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Base Decorator: Đóng gói đối tượng Pizza và cài đặt giao diện Pizza.
 */
public abstract class PizzaToppingDecorator implements Pizza {
    protected final Pizza pizza;

    public PizzaToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

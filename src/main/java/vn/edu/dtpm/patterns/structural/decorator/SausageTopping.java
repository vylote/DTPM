package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Concrete Decorator 2: Thêm Xúc Xích Tiêu Đỏ.
 */
public class SausageTopping extends PizzaToppingDecorator {
    public SausageTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Thêm Xúc Xích Pepperoni Tiêu Đỏ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 40_000.0;
    }
}

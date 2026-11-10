package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Base Decorator: Đóng gói đối tượng Pizza và cài đặt giao diện Pizza.
 */
abstract class PizzaToppingDecorator implements Pizza {
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

/**
 * Concrete Decorator 2: Thêm Xúc Xích Tiêu Đỏ.
 */
class SausageTopping extends PizzaToppingDecorator {
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

/**
 * Concrete Decorator 3: Thêm Nấm Đùi Gà Nướng Bơ Tỏi.
 */
class MushroomTopping extends PizzaToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Thêm Nấm Hương Nướng Bơ Tỏi";
    }

    @Override
    public double getCost() {
        return super.getCost() + 25_000.0;
    }
}


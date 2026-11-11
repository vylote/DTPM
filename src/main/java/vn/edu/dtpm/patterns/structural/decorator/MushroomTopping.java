package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Concrete Decorator 3: Thêm Nấm Đùi Gà Nướng Bơ Tỏi.
 */
public class MushroomTopping extends PizzaToppingDecorator {
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

package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Concrete Component 1: Pizza Margherita truyền thống.
 */
public class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Bánh Pizza Ý Margherita Cổ Điển (Sốt Cà Chua San Marzano & Húng Quế)";
    }

    @Override
    public double getCost() {
        return 120_000.0;
    }
}

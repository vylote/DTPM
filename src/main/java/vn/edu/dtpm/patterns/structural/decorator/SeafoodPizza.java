package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Concrete Component 2: Pizza Hải Sản cao cấp.
 */
public class SeafoodPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Bánh Pizza Hải Sản Tươi (Tôm Sú, Mực Nang, Sốt Pesto Ý)";
    }

    @Override
    public double getCost() {
        return 185_000.0;
    }
}

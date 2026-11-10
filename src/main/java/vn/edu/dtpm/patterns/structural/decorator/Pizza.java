package vn.edu.dtpm.patterns.structural.decorator;

/**
 * Component Interface: Giao diện cơ bản cho món Pizza.
 */
public interface Pizza {
    String getDescription();
    double getCost();
}

/**
 * Concrete Component 1: Pizza Margherita truyền thống.
 */
class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Bánh Pizza Ý Margherita Cổ Điển (Sốt Cà Chua San Marzano & Húng Quế)";
    }

    @Override
    public double getCost() {
        return 120_000.0;
    }
}

/**
 * Concrete Component 2: Pizza Hải Sản cao cấp.
 */
class SeafoodPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Bánh Pizza Hải Sản Tươi (Tôm Sú, Mực Nang, Sốt Pesto Ý)";
    }

    @Override
    public double getCost() {
        return 185_000.0;
    }
}


package vn.edu.dtpm.patterns.structural.decorator;

public class DecoratorTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ DECORATOR PATTERN: THÊM TOPPING PIZZA ---");
        System.out.println("==================================================");

        // 1. Pizza nguyên bản
        System.out.println("1. Khách hàng 1: Gọi Pizza Margherita nguyên bản:");
        Pizza basicPizza = new MargheritaPizza();
        System.out.printf("   Mô tả: %s\n   Tổng thanh toán: %,.0f VNĐ\n\n", basicPizza.getDescription(), basicPizza.getCost());

        // 2. Thêm 1 lớp Topping: Phô mai
        System.out.println("2. Khách hàng 2: Gọi Pizza Margherita + Thêm Phô Mai Mozzarella:");
        Pizza cheesePizza = new CheeseTopping(new MargheritaPizza());
        System.out.printf("   Mô tả: %s\n   Tổng thanh toán: %,.0f VNĐ\n\n", cheesePizza.getDescription(), cheesePizza.getCost());

        // 3. Chuỗi Decorator lồng nhau (Gấp đôi Phô Mai + Xúc Xích + Nấm Hương)
        System.out.println("3. Khách hàng 3 (VIP Combo): Pizza Hải Sản + Double Phô Mai + Xúc Xích Pepperoni + Nấm Nướng:");
        Pizza vipPizza = new SeafoodPizza();
        vipPizza = new CheeseTopping(vipPizza); // Lớp phô mai 1
        vipPizza = new CheeseTopping(vipPizza); // Lớp phô mai 2
        vipPizza = new SausageTopping(vipPizza); // Thêm xúc xích
        vipPizza = new MushroomTopping(vipPizza); // Thêm nấm hương

        System.out.println("   Mô tả chi tiết đơn hàng:\n   -> " + vipPizza.getDescription());
        System.out.printf("   TỔNG HÓA ĐƠN: %,.0f VNĐ\n", vipPizza.getCost());
    }
}


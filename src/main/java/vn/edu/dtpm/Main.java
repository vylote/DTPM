package vn.edu.dtpm;

import java.util.Scanner;
import vn.edu.dtpm.patterns.creational.singleton.SingletonTest;
import vn.edu.dtpm.patterns.creational.factorymethod.FactoryMethodTest;
import vn.edu.dtpm.patterns.creational.abstractfactory.AbstractFactoryTest;
import vn.edu.dtpm.patterns.creational.builder.BuilderTest;
import vn.edu.dtpm.patterns.creational.prototype.PrototypeTest;

import vn.edu.dtpm.patterns.structural.adapter.AdapterTest;
import vn.edu.dtpm.patterns.structural.facade.FacadeTest;
import vn.edu.dtpm.patterns.structural.composite.CompositeTest;
import vn.edu.dtpm.patterns.structural.bridge.BridgeTest;
import vn.edu.dtpm.patterns.structural.proxy.ProxyTest;
import vn.edu.dtpm.patterns.structural.flyweight.FlyweightTest;
import vn.edu.dtpm.patterns.structural.decorator.DecoratorTest;

import vn.edu.dtpm.patterns.behavioral.observer.ObserverTest;
import vn.edu.dtpm.patterns.behavioral.strategy.StrategyTest;
import vn.edu.dtpm.patterns.behavioral.state.StateTest;
import vn.edu.dtpm.patterns.behavioral.chainofresponsibility.ChainTest;
import vn.edu.dtpm.patterns.behavioral.command.CommandTest;
import vn.edu.dtpm.patterns.behavioral.templatemethod.TemplateMethodTest;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("   CHƯƠNG TRÌNH KIỂM THỬ 18 DESIGN PATTERNS - DTPM");
            System.out.println("==================================================");
            System.out.println("--- NHÓM KHỞI TẠO (CREATIONAL) ---");
            System.out.println(" 1. Singleton (Quản lý kết nối CSDL)");
            System.out.println(" 2. Factory Method (Phân tích đơn hàng Tiki/Shopee XML)");
            System.out.println(" 3. Abstract Factory (Bộ phân tích XML khách hàng NY/TW)");
            System.out.println(" 4. Builder (Cấu hình xe VinFast)");
            System.out.println(" 5. Prototype (Phân quyền người dùng FPT)");
            System.out.println("--- NHÓM CẤU TRÚC (STRUCTURAL) ---");
            System.out.println(" 6. Adapter (Chuyển đổi cổng thanh toán VNPay -> MoMo)");
            System.out.println(" 7. Façade (Máy chủ lập lịch công việc)");
            System.out.println(" 8. Composite (Cấu trúc phân cấp thẻ HTML)");
            System.out.println(" 9. Bridge (Hệ thống an ninh xe hơi VinFast/Toyota)");
            System.out.println("10. Proxy (Kiểm soát truy cập báo cáo doanh số)");
            System.out.println("11. Flyweight (Bộ tối ưu bộ nhớ thực thi code online)");
            System.out.println("12. Decorator (Thêm topping cho Pizza)");
            System.out.println("--- NHÓM HÀNH VI (BEHAVIORAL) ---");
            System.out.println("13. Observer (Gửi SMS tỷ số bóng đá cho khách hàng)");
            System.out.println("14. Strategy (Định dạng văn bản & Chiến lược thanh toán)");
            System.out.println("15. State (Điều khiển Robot thông minh)");
            System.out.println("16. Chain of Responsibility (Chuỗi xử lý file tự động)");
            System.out.println("17. Command (Quản lý hàng đợi công việc Thread Pool)");
            System.out.println("18. Template Method (Quy trình xử lý dữ liệu chuẩn)");
            System.out.println(" 0. Thoát chương trình");
            System.out.println("--------------------------------------------------");
            System.out.print("Nhập lựa chọn của bạn (0 - 18): ");

            if (!scanner.hasNextInt()) {
                String input = scanner.next();
                if ("exit".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)) {
                    System.out.println("Kết thúc chương trình kiểm thử!");
                    break;
                }
                System.out.println("Vui lòng nhập một số hợp lệ từ 0 đến 18.");
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Kết thúc chương trình kiểm thử!");
                break;
            }

            System.out.println("\n--- KẾT QUẢ CHẠY THỬ MẪU THIẾT KẾ ---");
            switch (choice) {
                case 1 -> SingletonTest.test();
                case 2 -> FactoryMethodTest.test();
                case 3 -> AbstractFactoryTest.test();
                case 4 -> BuilderTest.test();
                case 5 -> PrototypeTest.test();
                case 6 -> AdapterTest.test();
                case 7 -> FacadeTest.test();
                case 8 -> CompositeTest.test();
                case 9 -> BridgeTest.test();
                case 10 -> ProxyTest.test();
                case 11 -> FlyweightTest.test();
                case 12 -> DecoratorTest.test();
                case 13 -> ObserverTest.test();
                case 14 -> StrategyTest.test();
                case 15 -> StateTest.test();
                case 16 -> ChainTest.test();
                case 17 -> CommandTest.test();
                case 18 -> TemplateMethodTest.test();
                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 18.");
            }
        }
        scanner.close();
    }
}


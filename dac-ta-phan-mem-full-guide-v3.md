# TỔNG HỢP LÝ THUYẾT VÀ HƯỚNG DẪN XÂY DỰNG 1 PROJECT JAVA CHO 18 DESIGN PATTERNS (STANDARD MAVEN/GRADLE LAYOUT)

## 1. GIẢI PHÁP TỔ CHỨC 1 PROJECT JAVA DUY NHẤT (SINGLE ENTRY POINT)

Khi làm báo cáo thực hành 18 mẫu thiết kế, việc tạo 18 project độc lập sẽ rất cồng kềnh. Giải pháp tối ưu và thực tế nhất (tuân theo chuẩn thiết kế dự án Java thực tế với Maven / Gradle) là **tạo duy nhất 1 Java Project** với cấu trúc thư mục tiêu chuẩn `src/main/java` được chia theo các Package chuẩn hướng đối tượng.

### 1.1 Cấu trúc cây thư mục `src/main/java/` thực tế

```text
my-design-patterns-app/
├── pom.xml (hoặc build.gradle)
└── src/
    └── main/
        └── java/
            └── vn/
                └── edu/
                    └── dtpm/
                        ├── Main.java                          <-- HÀM MAIN DUY NHẤT CHẠY MENU CHỌN 18 MẪU
                        └── patterns/
                            ├── creational/                    <-- NHÓM KHỞI TẠO (5 MẪU)
                            │   ├── singleton/
                            │   │   ├── DatabaseConnection.java
                            │   │   └── SingletonTest.java
                            │   ├── factorymethod/
                            │   │   ├── OrderParser.java
                            │   │   ├── OrderParserFactory.java
                            │   │   └── FactoryMethodTest.java
                            │   ├── abstractfactory/
                            │   │   ├── NYXmlParserFactory.java
                            │   │   ├── TWXmlParserFactory.java
                            │   │   └── AbstractFactoryTest.java
                            │   ├── builder/
                            │   │   ├── VinFastCar.java
                            │   │   ├── CarBuilder.java
                            │   │   └── BuilderTest.java
                            │   └── prototype/
                            │       ├── AccessControl.java
                            │       └── PrototypeTest.java
                            │
                            ├── structural/                    <-- NHÓM CẤU TRÚC (7 MẪU)
                            │   ├── adapter/
                            │   │   ├── VNPayPayable.java
                            │   │   ├── MoMoPayable.java
                            │   │   ├── VNPayToMoMoAdapter.java
                            │   │   └── AdapterTest.java
                            │   ├── facade/
                            │   │   ├── ScheduleServerFacade.java
                            │   │   └── FacadeTest.java
                            │   ├── composite/
                            │   │   ├── HtmlTag.java
                            │   │   ├── HtmlParentElement.java
                            │   │   ├── HtmlElement.java
                            │   │   └── CompositeTest.java
                            │   ├── bridge/
                            │   │   ├── Vehicle.java
                            │   │   ├── SecurityProduct.java
                            │   │   └── BridgeTest.java
                            │   ├── proxy/
                            │   │   ├── ReportGeneratorProxy.java
                            │   │   └── ProxyTest.java
                            │   ├── flyweight/
                            │   │   ├── PlatformFactory.java
                            │   │   └── FlyweightTest.java
                            │   └── decorator/
                            │       ├── Pizza.java
                            │       ├── CheeseTopping.java
                            │       └── DecoratorTest.java
                            │
                            └── behavioral/                    <-- NHÓM HÀNH VI (6 MẪU)
                                ├── observer/
                                │   ├── Subject.java
                                │   ├── SMSUserObserver.java
                                │   └── ObserverTest.java
                                ├── strategy/
                                │   ├── PaymentStrategy.java
                                │   ├── TextFormatter.java
                                │   └── StrategyTest.java
                                ├── state/
                                │   ├── RobotState.java
                                │   └── StateTest.java
                                ├── chainofresponsibility/
                                │   ├── FileHandler.java
                                │   └── ChainTest.java
                                ├── command/
                                │   ├── JobCommand.java
                                │   └── CommandTest.java
                                └── templatemethod/
                                    ├── DataProcessorTemplate.java
                                    └── TemplateMethodTest.java
```

---

### 1.2 Mã nguồn file điều khiển duy nhất `Main.java` (`src/main/java/vn/edu/dtpm/Main.java`)

Tất cả các bài kiểm thử của 18 mẫu thiết kế thay vì chạy bằng 18 hàm `main` riêng lẻ sẽ được bọc trong một phương thức tĩnh `public static void test()` ở mỗi lớp kiểm thử. File `Main.java` sẽ đóng vai trò Menu tương tác Console:

```java
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
```

---

## 2. DANH SÁCH 18 MẪU THIẾT KẾ ĐÃ VIỆT HÓA KỊCH BẢN THỰC TẾ

| STT | Tên Mẫu Design Pattern | Nhóm Mẫu | Kịch bản Bài toán Thực tế Việt hóa | Package trong Project Java (`src/main/java/`) |
|---|---|---|---|---|
| 1 | **Singleton** | Creational | Quản lý kết nối Cơ sở dữ liệu duy nhất cho ứng dụng | `vn.edu.dtpm.patterns.creational.singleton` |
| 2 | **Factory Method** | Creational | Phân tích đơn hàng tự động từ Tiki / Shopee (gói XML) | `vn.edu.dtpm.patterns.creational.factorymethod` |
| 3 | **Abstract Factory** | Creational | Tích hợp hệ thống XML chuyên biệt cho đối tác Hàn Quốc & Nhật Bản | `vn.edu.dtpm.patterns.creational.abstractfactory` |
| 4 | **Builder** | Creational | Tùy chỉnh cấu hình xe ô tô VinFast (Sedan, SUV, Sport) | `vn.edu.dtpm.patterns.creational.builder` |
| 5 | **Prototype** | Creational | Nhân bản cấu hình phân quyền người dùng trong hệ thống FPT | `vn.edu.dtpm.patterns.creational.prototype` |
| 6 | **Adapter** | Structural | Chuyển đổi giao diện tích hợp cổng thanh toán từ VNPay sang MoMo | `vn.edu.dtpm.patterns.structural.adapter` |
| 7 | **Façade** | Structural | Đơn giản hóa giao diện điều khiển máy chủ gửi tin nhắn Viettel | `vn.edu.dtpm.patterns.structural.facade` |
| 8 | **Composite** | Structural | Xây dựng cấu trúc cây phân cấp cho các thẻ HTML / DOM | `vn.edu.dtpm.patterns.structural.composite` |
| 9 | **Bridge** | Structural | Tích hợp hệ thống an ninh độc lập cho các dòng xe VinFast & Toyota | `vn.edu.dtpm.patterns.structural.bridge` |
| 10 | **Proxy** | Structural | Kiểm soát quyền xuất báo cáo doanh số cho Quản lý (Owner Proxy) | `vn.edu.dtpm.patterns.structural.proxy` |
| 11 | **Flyweight** | Structural | Tối ưu bộ nhớ hệ thống chấm code tự động cho sinh viên | `vn.edu.dtpm.patterns.structural.flyweight` |
| 12 | **Decorator** | Structural | Tính tiền linh hoạt khi thêm topping (phô mai, xúc xích) vào bánh Pizza | `vn.edu.dtpm.patterns.structural.decorator` |
| 13 | **Observer** | Behavioral | Tự động gửi tin nhắn SMS thông báo tỷ số bóng đá cho Cổ động viên | `vn.edu.dtpm.patterns.behavioral.observer` |
| 14 | **Strategy** | Behavioral | Thay đổi thuật toán định dạng văn bản / Phương thức thanh toán linh hoạt | `vn.edu.dtpm.patterns.behavioral.strategy` |
| 15 | **State** | Behavioral | Đóng gói hành vi chuyển đổi trạng thái của Robot nấu ăn | `vn.edu.dtpm.patterns.behavioral.state` |
| 16 | **Chain of Responsibility** | Behavioral | Chuỗi tự động phân loại và lưu trữ file (Text, Excel, Audio) | `vn.edu.dtpm.patterns.behavioral.chainofresponsibility` |
| 17 | **Command** | Behavioral | Đóng gói công việc hệ thống vào hàng đợi Thread Pool | `vn.edu.dtpm.patterns.behavioral.command` |
| 18 | **Template Method** | Behavioral | Định nghĩa quy trình xử lý dữ liệu chuẩn cho MySQL và Oracle | `vn.edu.dtpm.patterns.behavioral.templatemethod` |

---

## 3. TÓM TẮT LÝ THUYẾT NỀN TẢNG (CHƯƠNG 1 TỚI CHƯƠNG 5)

### 3.1 Trừu tượng hóa & Nguyên lý thế Liskov (LSP - Chương 1)
* **Trừu tượng hóa dữ liệu**: Sử dụng `Interface` và `Abstract Class` để che giấu chi tiết cài đặt bên trong, chỉ để lộ các giao diện thao tác ra bên ngoài.
* **Nguyên lý thế Liskov (Liskov Substitution Principle)**: Nếu $S$ là kiểu con của $T$, thì các đối tượng kiểu $T$ trong chương trình có thể được thay thế bằng các đối tượng kiểu $S$ mà không làm thay đổi tính đúng đắn của chương trình.

### 3.2 Phân tích bài toán & Phân rã Module (Chương 2 & 3)
* **Kịch bản (Scenarios)**: Trích xuất các yêu cầu thực tế thành chuỗi các thao tác cần thiết.
* **Lược đồ phụ thuộc Module (MDD)**: Biểu diễn sự phụ thuộc giữa các trừu tượng dữ liệu và các thủ tục.

### 3.3 Tiêu chuẩn đánh giá thiết kế (Chương 4)
* **Độ gắn kết cao (High Cohesion)**: Mỗi lớp/module chỉ đảm nhận duy nhất một trách nhiệm trừu tượng.
* **Gắn kết lỏng lẻo (Loose Coupling)**: Giảm thiểu sự phụ thuộc trực tiếp giữa các lớp, giúp hệ thống dễ mở rộng và bảo trì.

### 3.4 Phương pháp đặc tả hình thức B-Method (Chương 5)
* Phương pháp toán học dựa trên **Máy trừu tượng (Abstract Machine)**, điều kiện bất biến (Invariant) và các phép chứng minh hình thức (Proof Obligations) sáng tạo bởi Jean-Raymond Abrial.

---

## 4. CHI TIẾT KHUNG BÁO CÁO MẪU CHO 18 DESIGN PATTERNS

### Mẫu 6: Adapter Pattern (Ví dụ minh họa chi tiết theo chuẩn 4 mục)

#### 1. Tên mẫu & Phân loại
* **Tên mẫu**: Adapter Pattern
* **Nhóm**: Nhóm cấu trúc (Structural Patterns)

#### 2. Kịch bản bài toán Việt hóa
Hệ thống thương mại điện tử hiện tại đang tích hợp thanh toán qua cổng `VNPay`. Do chính sách kinh doanh mới, công ty quyết định chuyển sang sử dụng cổng thanh toán `MoMo`. Tuy nhiên, API của `MoMo` có tên phương thức và tham số hoàn toàn khác với `VNPay`. Để tránh phải sửa đổi mã nguồn hiện có của hệ thống, lập trình viên tạo lớp `VNPayToMoMoAdapter` bọc lấy đối tượng `VNPay` và cài đặt giao diện `MoMoPayable`.

#### 3. Sơ đồ lớp UML (Class Diagram)

```text
+-------------------+             +-----------------------+
|   MoMoPayable     |             |     VNPayPayable      |
|   (Interface)     |             |     (Interface)       |
+-------------------+             +-----------------------+
| + processMoMo()   |             | + sendVNPayAmount()   |
+---------^---------+             +-----------^-----------+
          |                                   |
          | implements                        | implements
+---------+---------------+         +---------+-----------+
|  VNPayToMoMoAdapter     |         |     VNPayImpl       |
+-------------------------+         +---------------------+
| - vnpay: VNPayPayable   |----->   | - amount: double    |
+-------------------------+ (wraps) +---------------------+
| + processMoMo()         |         
+-------------------------+
```

#### 4. Giao diện kiểm thử (Code Java kiểm thử Console trong Project - `src/main/java/vn/edu/dtpm/patterns/structural/adapter/AdapterTest.java`)

```java
package vn.edu.dtpm.patterns.structural.adapter;

// 1. Giao diện hiện tại (MoMo)
interface MoMoPayable {
    void processMoMoPayment(double amountInVnd);
}

// 2. Giao diện cũ / bên thứ ba (VNPay)
interface VNPayPayable {
    void executeVNPayTransaction(String txnId, double amount);
}

class VNPayImpl implements VNPayPayable {
    @Override
    public void executeVNPayTransaction(String txnId, double amount) {
        System.out.println("[VNPay Engine] Đã xử lý giao dịch ID: " + txnId + " | Số tiền: " + amount + " VND");
    }
}

// 3. Lớp Adapter chuyển đổi từ VNPay sang MoMo
class VNPayToMoMoAdapter implements MoMoPayable {
    private VNPayPayable vnpayService;

    public VNPayToMoMoAdapter(VNPayPayable vnpayService) {
        this.vnpayService = vnpayService;
    }

    @Override
    public void processMoMoPayment(double amountInVnd) {
        String generatedTxnId = "MOMO_ADAPT_" + System.currentTimeMillis();
        System.out.println("[Adapter] Chuyển đổi lời gọi MoMoPayment() sang VNPayTransaction()...");
        vnpayService.executeVNPayTransaction(generatedTxnId, amountInVnd);
    }
}

// 4. Lớp kiểm thử dành cho Menu Main
public class AdapterTest {
    public static void test() {
        System.out.println("--- DEMO ADAPTER PATTERN (VNPAY -> MOMO) ---");
        VNPayPayable vnpay = new VNPayImpl();
        MoMoPayable adapter = new VNPayToMoMoAdapter(vnpay);

        // Client gọi qua giao diện MoMo nhưng chạy mã nguồn VNPay bên dưới
        adapter.processMoMoPayment(500000.0);
    }
}
```

---

*Tài liệu này được xuất bản tự động dưới dạng file Markdown `.md` cho dự án môn học Đặc tả phần mềm (DTPM).*

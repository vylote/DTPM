# SỔ TAY HỎI ĐÁP KIẾN TRÚC 18 DESIGN PATTERNS

> **Mục tiêu:** Ghi nhớ nhanh, súc tích, đi thẳng vào bản chất kỹ thuật (JVM, bộ nhớ, đa luồng) và phản biện kiến trúc.

---

## I. NHÓM KHỞI TẠO (CREATIONAL PATTERNS)

### 1. SINGLETON PATTERN (`DatabaseConnection.java`)
* **Bài toán:** Quản lý duy nhất 1 kết nối CSDL dùng chung để tiết kiệm tài nguyên và tránh cạn kiệt Connection Pool.

---

#### ❓ Câu 1: Tại sao `dbUrl`, `username`, `logs` có `final`, còn `isConnected` thì không?
* **Có `final`:**
  * `dbUrl`, `username`: Cấu hình cố định, không được phép gán lại sang database khác.
  * `executionLogs`: Đảm bảo biến luôn trỏ cố định vào đúng 1 danh sách khởi tạo ban đầu (không bị gán đè `null`).
* **Không `final` (`isConnected`):** Đại diện cho trạng thái hoạt động (bật/tắt kết nối). Phải thay đổi được giá trị `true`/`false` khi gọi `disconnect()` hoặc `reconnect()`.

---

#### ❓ Câu 2: Tại sao constructor phải để `private`?
* **Đáp:** Để tước quyền gọi `new DatabaseConnection()` từ bên ngoài $\rightarrow$ Ép buộc mọi nơi trong hệ thống phải đi qua cổng duy nhất là `getInstance()`.

---

#### ❓ Câu 3: Đối tượng ở Heap, tham chiếu ở Stack? Biến static có cần getter không?
* **Vùng nhớ:**
  * **Heap:** Nơi lưu dữ liệu thực tế của đối tượng (`new DatabaseConnection()`).
  * **Stack:** Nơi lưu các biến con trỏ tạm thời trong hàm (giữ địa chỉ ô nhớ trỏ sang Heap).
* **Static & Getter:**
  * Việc có cần `getter` hay không do **`public`** hay **`private`** quyết định, không liên quan đến biến static.
  * Nếu để `private static`, bắt buộc phải có getter (chính là hàm `getInstance()`).
  * Từ khóa `static` chỉ có nghĩa: biến này thuộc về **Lớp**, gọi trực tiếp qua tên lớp mà không cần khởi tạo đối tượng trước.

---

#### ❓ Câu 4: "Nạp class vào JVM" là gì?
* **Phân biệt:** `javac` dịch `.java` thành `.class`. JVM là máy ảo để chạy file `.class`.
* **Nạp theo nhu cầu (On-demand):** JVM không nạp hàng nghìn class cùng lúc vào RAM. Chỉ khi code thực sự gọi đến class đó, JVM mới đọc file `.class` từ đĩa vào bộ nhớ.
* **Với Singleton:** Class con `SingletonHelper` là 1 file riêng (`DatabaseConnection$SingletonHelper.class`). Nó chỉ được nạp vào RAM khi có ai đó gọi `getInstance()`.

---

#### ❓ Câu 5: Tại sao Lazy Loading dùng `synchronized` lại gây chậm?
* **Nguyên nhân:** JVM coi `synchronized` như căn phòng có khóa cửa.
* **Nghẽn cổ chai:** Dù đối tượng đã tạo xong rồi, **mọi lượt gọi sau đó vẫn bị bắt dừng lại để giành chìa khóa** $\rightarrow$ Hàng nghìn luồng phải xếp hàng (Lock Contention), làm CPU tốn tài nguyên đóng băng/đánh thức luồng (Context Switching).

---

#### ❓ Câu 6: Cả hai đều dùng khóa, sao Bill Pugh (`SingletonHelper`) lại nhanh hơn `synchronized`?
* **Khác biệt cốt lõi ở TẦN SUẤT KHÓA:**
  * **`synchronized`:** Khóa **100% mọi lần gọi** (100 triệu request = 100 triệu lần khóa/mở khóa).
  * **Bill Pugh:** Khóa **đúng 1 lần duy nhất** lúc JVM nạp class `SingletonHelper` lần đầu (nhờ cơ chế an toàn nội tại của JVM). Từ lần gọi thứ 2 trở đi, **hoàn toàn không còn khóa nào nữa**, đọc thẳng biến static với tốc độ tối đa.

---

#### ❓ Câu 7: Singleton Java thuần khác gì Singleton Bean trong Spring Boot?
* **Java thuần (ClassLoader-level):** Dùng `private constructor` để máy ảo JVM cấm tiệt lệnh `new`. Bắt buộc dùng khi viết Core SDK, thư viện, CLI không có Spring.
* **Spring Boot (Container-level):** Class vẫn có `public constructor`. Spring tự tạo 1 instance cất vào Map nội bộ (`ApplicationContext`) để tiêm (`@Autowired`). Nếu cố tình gọi `new`, Java vẫn tạo đối tượng thứ hai bình thường.

---

### 2. FACTORY METHOD PATTERN (`OrderParser.java`, `OrderParserFactory.java`)
* **Bài toán:** Bóc tách dữ liệu đơn hàng XML từ nhiều sàn TMĐT (Tiki, Shopee) có cấu trúc XML khác nhau.

---

#### ❓ Câu 1: Tại sao việc bóc tách dữ liệu XML lại thuộc nhóm Khởi tạo (Creational)?
* **Đáp:**
  * "Bóc tách XML" chỉ là nghiệp vụ nền (hành vi).
  * Trọng tâm mẫu này là: **Tách hành động khởi tạo (`new`) ra khỏi logic xử lý**.
  * Thay vì hard-code `if-else` gọi `new TikiOrderParser()`, lớp cha định nghĩa phương thức trừu tượng `createParser()` và ủy quyền việc tạo đối tượng cụ thể cho các lớp Factory con. Giúp dễ dàng thêm sàn mới (Lazada, TikTok Shop) mà không cần sửa code cũ (tuân thủ Open/Closed Principle - OCP).

---

#### ❓ Câu 2: Tại sao gọi là "Factory METHOD" mà không phải "Factory Class"?
* **Đáp:**
  * Lớp cha giữ quy trình nghiệp vụ chung (`processOrder`), chỉ để trống **DUY NHẤT 1 PHƯƠNG THỨC** trừu tượng (`abstract OrderParser createParser()`).
  * Lớp con kế thừa chỉ cần override đúng phương thức (`Method`) này để quyết định sản phẩm được tạo. Vì bản chất dựa vào việc ghi đè phương thức thay vì sinh ra 1 class `switch-case` riêng, nên gọi là Factory Method.

---

### 3. ABSTRACT FACTORY PATTERN (`XMLParserFactory.java`)
* **Bài toán:** Bóc tách đồng thời một họ các định dạng XML cho đối tác quốc tế: Đơn hàng (`Order`), Đánh giá (`Feedback`), Vận chuyển (`Shipping`) theo từng khu vực (New York - Bắc Mỹ vs Taiwan - Châu Á).

---

#### ❓ Câu 1: Abstract Factory khác gì Factory Method?
* **Factory Method (Mua món lẻ):** Chỉ tạo **1 sản phẩm đơn lẻ** (`OrderParser`).
* **Abstract Factory (Mua trọn bộ Combo):** Tạo **cả một họ sản phẩm liên quan** (`Order` + `Feedback` + `Shipping`). Đảm bảo tính đồng bộ 100%: đã chọn nhà máy New York thì cả 3 parser đều chuẩn New York, không bị lẫn với Taiwan.

---

#### ❓ Câu 2: Nhược điểm lớn nhất của Abstract Factory là gì?
* **Khó mở rộng thêm loại sản phẩm mới:**
  * Mỗi nhà máy con phải tự implement toàn bộ các class sản phẩm trong họ của mình rồi nhét vào factory.
  * Khi interface gốc `XMLParserFactory` thay đổi (ví dụ thêm `createShippingParser()`), **toàn bộ các factory con (`NYXmlParserFactory`, `TWXmlParserFactory`...) đều bị lỗi biên dịch** và bắt buộc phải viết thêm code (vi phạm Open/Closed Principle khi mở rộng chủng loại sản phẩm).

---
*(Sẽ tiếp tục bổ sung ngắn gọn cho các pattern tiếp theo...)*

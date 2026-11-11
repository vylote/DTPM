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

### 4. BUILDER PATTERN (`VinFastCar.java`, `CarBuilder.java`)
* **Bản chất:** Xây dựng một đối tượng phức tạp từng bước một (step-by-step) bằng cách tách rời quy trình lắp ráp ra khỏi đối tượng thực tế.
* **Bài toán:** Cấu hình xe ô tô điện VinFast với 10 tùy chọn phức tạp (model, động cơ, pin, màu sắc, ghế Nappa, cửa sổ trời, ADAS, giá...). Thay vì gọi constructor dài ngoằng hoặc setter nguy hiểm, ta dùng Builder tự quản lý, có sẵn thông số mặc định, thích cấu hình trường nào thì gọi hàm đó, cuối cùng bấm `.build()` để ra xe hoàn chỉnh.

---

#### ❓ Câu 1: Builder giải quyết vấn đề gì? Tại sao không dùng constructor dài hay Setter?
* **Hội chứng Telescoping Constructor (Kính thiên văn):** Constructor 10 tham số rất dễ truyền nhầm thứ tự các biến cùng kiểu (`boolean`, `String`), code rối và khó đọc.
* **Tại sao không dùng Setter?**
  * Setter làm đối tượng rơi vào trạng thái không toàn vẹn (inconsistent state) khi đang set dở.
  * Khiến đối tượng bị thay đổi được (Mutable), không an toàn đa luồng.
  * Builder cho phép toàn bộ 10 thuộc tính của `VinFastCar` đều là **`final` (Immutable)**.

---

#### ❓ Câu 2: Lệnh `return this` trong Builder có tác dụng gì?
* **Đáp:** Cho phép viết mã theo phong cách **Fluent Interface (Method Chaining)**: `.setModel(...).setColor(...).build()`. Mỗi hàm trả về chính đối tượng builder (`this`) để chấm nối đuôi nhau liên tục.

---

#### ❓ Câu 3: Vai trò của `VinFastDirector` là gì?
* **Đáp:** Đóng vai trò như bảng cấu hình mẫu sẵn của hãng (VF8 Plus, VF9 Executive). Khách hàng thích tùy biến cá nhân (Custom Order) thì tự gọi builder trực tiếp mà không cần qua Director.

---

#### ❓ Câu 4: Tại sao việc kiểm tra hợp lệ (Validation) phải đặt ở hàm `build()` mà không đặt ở từng hàm `set...()`?
* **Đáp:** Vì nhiều logic nghiệp vụ cần kiểm tra mối quan hệ chéo giữa các thuộc tính (ví dụ: *Xe có cửa sổ trời thì bắt buộc phải từ 5 chỗ trở lên*). Nếu validate ở setter, tại thời điểm gọi có thể thuộc tính kia chưa được set. Đặt ở `build()` đảm bảo gom đủ mọi linh kiện rồi mới kiểm tra tổng thể trước khi tạo đối tượng thật.

---

#### ❓ Câu 5: Tại sao constructor của `VinFastCar` để package-private chứ không để `public`?
* **Đáp:** Để ngăn chặn lập trình viên "đi đường tắt" (cố tình gọi `new VinFastCar(...)` 10 tham số). Ép buộc 100% việc tạo xe đều phải thông qua `CarBuilder`.

---

#### ❓ Câu 6: GoF Builder (bài này) khác gì Lombok `@Builder` trong Spring Boot?
* **GoF Builder:** Tách riêng Interface `Builder` và `Director`. Dùng cùng một quy trình lắp ráp nhưng có thể tạo ra nhiều biểu diễn khác nhau (ví dụ: vừa ráp xe thật `VinFastCar`, vừa ráp sách hướng dẫn `CarManual`).
* **Lombok `@Builder` (Effective Java):** Chỉ là một static class lồng bên trong Product, không có interface hay Director, mục đích thuần túy là viết code gọn trong backend hàng ngày.

---

### 5. PROTOTYPE PATTERN (`AccessControl.java`, `AccessControlRegistry.java`)
* **Bài toán:** Nhân bản cấu hình phân quyền nhân viên FPT Corporation từ các mẫu chuẩn định sẵn (Admin, Dev, PM) để tiết kiệm tài nguyên khởi tạo.

---

#### ❓ Câu 1: Phân biệt Shallow Copy và Deep Copy? Nếu làm sai sẽ nguy hiểm thế nào?
* **Shallow Copy (`super.clone()` mặc định):** Chỉ sao chép biến nguyên thủy và `String`. Với `List<String> permissions`, nó chỉ sao chép địa chỉ con trỏ $\rightarrow$ Cả bản sao và bản gốc đều trỏ chung vào 1 danh sách. Nếu cấp thêm quyền cho bản sao, bản mẫu gốc cũng bị gán thêm quyền đó theo (lỗi bảo mật nghiêm trọng).
* **Deep Copy (Trong code của chúng ta):** `cloned.permissions = new ArrayList<>(this.permissions);` $\rightarrow$ Cấp phát vùng nhớ `List` hoàn toàn độc lập trên Heap.

---

#### ❓ Câu 2: Interface `Cloneable` trong Java có gì đặc biệt?
* **Đáp:** Là một **Marker Interface (Giao diện rỗng)** không có bất kỳ hàm nào.
* Phương thức `clone()` thực chất thuộc về lớp `java.lang.Object`. Việc implement `Cloneable` đóng vai trò như "tấm vé thông hành" cho phép JVM gọi `super.clone()`. Nếu không implement mà gọi `super.clone()`, JVM sẽ ném lỗi `CloneNotSupportedException`.

---

#### ❓ Câu 3: Vai trò của `AccessControlRegistry` là gì?
* **Đáp:** Là một **Prototype Cache**: Lưu sẵn một bảng băm `Map<String, AccessControl>` chứa các mẫu chuẩn. Client chỉ cần xin quyền theo tên mẫu (`DEV_TEMPLATE`), Registry tự động gọi `.clone()` và trả về bản sao độc lập mà client không cần biết logic nhân bản bên dưới.

---
*(Sẽ tiếp tục bổ sung ngắn gọn cho các pattern tiếp theo...)*

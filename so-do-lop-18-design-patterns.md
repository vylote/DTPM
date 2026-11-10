# TỔNG HỢP SƠ ĐỒ LỚP (UML CLASS DIAGRAMS) CHUẨN KIẾN TRÚC CHO 18 DESIGN PATTERNS
> **Dự án:** 18 Mẫu Thiết Kế Hướng Đối Tượng - Đặc Tả Phần Mềm (DTPM)  
> **Ngôn ngữ:** Java SE 21 | **Chuẩn thiết kế:** GoF (Gang of Four) & UML 2.5 Tiêu Chuẩn  
> **Quy tắc vàng:** Chỉ biểu diễn các thành phần kiến trúc cốt lõi của Pattern, **LOẠI BỎ TOÀN BỘ CÁC LỚP TEST / CLIENT THỪA THÃI**.  
> **Định dạng trực quan:** Chuẩn Draw.io (Hộp chữ nhật 3 ngăn viền đen nền trắng, ký hiệu `+`, `-`, `#`, không icon tròn `(C)`, đường nối thẳng vuông góc 90°).

---

## 🎨 CẤU HÌNH ĐỒ HỌA TRỰC QUAN CHO DRAW.IO (ÁP DỤNG ĐỒNG BỘ 18 MẪU)

Tất cả 18 sơ đồ dưới đây đều được cấu hình với các tham số tối ưu hóa hiển thị cho Draw.io:
```plantuml
hide circle                          ' Xóa bỏ hoàn toàn biểu tượng hình tròn (C) trên tên Class
skinparam classAttributeIconSize 0   ' Hiển thị trực tiếp ký tự +, -, # thay vì icon màu
skinparam monochrome true            ' Đưa về chuẩn đen trắng cổ điển, sắc nét
skinparam shadowing false            ' Tắt hiệu ứng đổ bóng mờ
skinparam linetype ortho             ' Đường nối vuông góc 90 độ (Orthogonal), không cong queo
skinparam roundcorner 0              ' Góc hộp vuông vức 100% chuẩn Draw.io
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}
```

---

## 🚀 HƯỚNG DẪN IMPORT VÀO DRAW.IO (3 BƯỚC)

1. Mở trang [draw.io](https://app.diagrams.net/).
2. Chọn menu: **Sắp xếp (Arrange)** ➔ **Chèn (Insert)** ➔ **Nâng cao (Advanced)** ➔ **PlantUML...**
3. **Copy toàn bộ khối mã `@startuml ... @enduml`** của mẫu cần vẽ, dán vào khung và nhấn **Chèn (Insert)**.

---

# PHẦN 1: NHÓM KHỞI TẠO (CREATIONAL PATTERNS) - 5 MẪU

---

### MẪU 1: SINGLETON PATTERN (Quản lý kết nối CSDL duy nhất)
* **Bản chất kiến trúc:** Chỉ có **DUY NHẤT 1 HỘP LỚP** đại diện cho đối tượng Singleton với phương thức khởi tạo riêng tư `private DatabaseConnection()` và thuộc tính tĩnh `- instance` tự trỏ về chính nó.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

class DatabaseConnection {
    - {static} instance: DatabaseConnection
    - dbUrl: String
    - username: String
    - executionLogs: List<String>
    - isConnected: boolean
    - DatabaseConnection()
    + {static} getInstance(): DatabaseConnection
    + executeQuery(sql: String): void
    + executeUpdate(sql: String): void
    + disconnect(): void
    + reconnect(): void
    + getExecutionLogs(): List<String>
    + isConnected(): boolean
}

DatabaseConnection "1" --> "1" DatabaseConnection : - instance
@enduml
```

---

### MẪU 2: FACTORY METHOD PATTERN (Phân tích đơn hàng Tiki / Shopee XML)
* **Bản chất kiến trúc:** Phân tách rõ rệt giữa cấu trúc phân cấp Sản phẩm (`OrderParser`) và phân cấp Khởi tạo (`OrderParserFactory`).

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface OrderParser <<interface>> {
    + parseOrder(xmlData: String): String
    + getPlatformName(): String
}

class TikiOrderParser {
    + parseOrder(xmlData: String): String
    + getPlatformName(): String
    - extractTag(xml: String, tag: String, defVal: String): String
}

class ShopeeOrderParser {
    + parseOrder(xmlData: String): String
    + getPlatformName(): String
    - extractTag(xml: String, tag: String, defVal: String): String
}

abstract class OrderParserFactory <<abstract>> {
    + {abstract} createParser(): OrderParser
    + processOrder(xmlData: String): void
}

class TikiOrderParserFactory {
    + createParser(): OrderParser
}

class ShopeeOrderParserFactory {
    + createParser(): OrderParser
}

OrderParser <|.. TikiOrderParser : Implements
OrderParser <|.. ShopeeOrderParser : Implements

OrderParserFactory <|-- TikiOrderParserFactory : Extends
OrderParserFactory <|-- ShopeeOrderParserFactory : Extends

TikiOrderParserFactory ..> TikiOrderParser : creates
ShopeeOrderParserFactory ..> ShopeeOrderParser : creates
OrderParserFactory ..> OrderParser : uses
@enduml
```

---

### MẪU 3: ABSTRACT FACTORY PATTERN (Bộ phân tích XML Khách hàng NY / TW)
* **Bản chất kiến trúc:** Cung cấp giao diện `XMLParserFactory` để khởi tạo họ các bộ phân tích (`OrderXMLParser` và `FeedbackXMLParser`) tương ứng cho từng đối tác.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface OrderXMLParser <<interface>> {
    + parseOrderXML(xml: String): String
}

class NYOrderXMLParser {
    + parseOrderXML(xml: String): String
}

class TWOrderXMLParser {
    + parseOrderXML(xml: String): String
}

interface FeedbackXMLParser <<interface>> {
    + parseFeedbackXML(xml: String): String
}

class NYFeedbackXMLParser {
    + parseFeedbackXML(xml: String): String
}

class TWFeedbackXMLParser {
    + parseFeedbackXML(xml: String): String
}

interface XMLParserFactory <<interface>> {
    + createOrderParser(): OrderXMLParser
    + createFeedbackParser(): FeedbackXMLParser
    + getFactoryRegion(): String
}

class NYXmlParserFactory {
    + createOrderParser(): OrderXMLParser
    + createFeedbackParser(): FeedbackXMLParser
    + getFactoryRegion(): String
}

class TWXmlParserFactory {
    + createOrderParser(): OrderXMLParser
    + createFeedbackParser(): FeedbackXMLParser
    + getFactoryRegion(): String
}

OrderXMLParser <|.. NYOrderXMLParser : Implements
OrderXMLParser <|.. TWOrderXMLParser : Implements

FeedbackXMLParser <|.. NYFeedbackXMLParser : Implements
FeedbackXMLParser <|.. TWFeedbackXMLParser : Implements

XMLParserFactory <|.. NYXmlParserFactory : Implements
XMLParserFactory <|.. TWXmlParserFactory : Implements

NYXmlParserFactory ..> NYOrderXMLParser : creates
NYXmlParserFactory ..> NYFeedbackXMLParser : creates
TWXmlParserFactory ..> TWOrderXMLParser : creates
TWXmlParserFactory ..> TWFeedbackXMLParser : creates
@enduml
```

---

### MẪU 4: BUILDER PATTERN (Cấu hình xe VinFast)
* **Bản chất kiến trúc:** Tách rời cấu trúc sản phẩm phức tạp `VinFastCar` khỏi quy trình lắp ráp `CarBuilder`, dưới sự điều phối của `VinFastDirector`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

class VinFastCar {
    - model: String
    - carType: String
    - engineType: String
    - batteryCapacity: String
    - color: String
    - interior: String
    - autopilot: boolean
    - panoramicSunroof: boolean
    - seats: int
    - priceVnd: double
    ~ VinFastCar(...)
    + toString(): String
}

interface CarBuilder <<interface>> {
    + setModel(model: String): CarBuilder
    + setCarType(carType: String): CarBuilder
    + setEngineType(engineType: String): CarBuilder
    + setBatteryCapacity(batteryCapacity: String): CarBuilder
    + setColor(color: String): CarBuilder
    + setInterior(interior: String): CarBuilder
    + setAutopilot(autopilot: boolean): CarBuilder
    + setPanoramicSunroof(panoramicSunroof: boolean): CarBuilder
    + setSeats(seats: int): CarBuilder
    + setPriceVnd(priceVnd: double): CarBuilder
    + build(): VinFastCar
}

class VinFastCarConcreteBuilder {
    - model: String
    - carType: String
    - engineType: String
    - batteryCapacity: String
    - color: String
    - interior: String
    - autopilot: boolean
    - panoramicSunroof: boolean
    - seats: int
    - priceVnd: double
    + build(): VinFastCar
}

class VinFastDirector {
    + constructVF8Plus(builder: CarBuilder): VinFastCar
    + constructVF9Executive(builder: CarBuilder): VinFastCar
    + constructLuxA2Sedan(builder: CarBuilder): VinFastCar
}

CarBuilder <|.. VinFastCarConcreteBuilder : Implements
VinFastCarConcreteBuilder ..> VinFastCar : builds
VinFastDirector "1" o-- "1" CarBuilder : directs
@enduml
```

---

### MẪU 5: PROTOTYPE PATTERN (Nhân bản phân quyền FPT)
* **Bản chất kiến trúc:** Đối tượng `AccessControl` cài đặt giao diện `Cloneable` để tự nhân bản thông qua phương thức `clone()`, được quản lý tập trung bởi `AccessControlRegistry`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface Cloneable <<interface>>

class AccessControl {
    - roleName: String
    - assignedUser: String
    - department: String
    - permissions: List<String>
    + AccessControl(role: String, user: String, dept: String, perms: List<String>)
    + addPermission(permission: String): void
    + revokePermission(permission: String): void
    + clone(): AccessControl
    + toString(): String
}

class AccessControlRegistry {
    - {static} REGISTRY: Map<String, AccessControl>
    + {static} getPrototype(key: String): AccessControl
    + {static} getRawTemplate(key: String): AccessControl
}

Cloneable <|.. AccessControl : Implements
AccessControlRegistry "1" o-- "1..*" AccessControl : stores prototypes
AccessControl "1" ..> "1" AccessControl : clone()
@enduml
```

---

# PHẦN 2: NHÓM CẤU TRÚC (STRUCTURAL PATTERNS) - 7 MẪU

---

### MẪU 6: ADAPTER PATTERN (Chuyển đổi cổng thanh toán VNPay ➔ MoMo)
* **Bản chất kiến trúc:** Lớp `VNPayToMoMoAdapter` cài đặt giao diện mục tiêu `MoMoPayable` và bọc tham chiếu đến đối tượng thực thi `VNPayPayable`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface MoMoPayable <<interface>> {
    + processMoMoPayment(amountInVnd: double): void
}

interface VNPayPayable <<interface>> {
    + executeVNPayTransaction(txnId: String, amount: double): void
}

class VNPayImpl {
    + executeVNPayTransaction(txnId: String, amount: double): void
}

class VNPayToMoMoAdapter {
    - vnpayService: VNPayPayable
    + VNPayToMoMoAdapter(vnpayService: VNPayPayable)
    + processMoMoPayment(amountInVnd: double): void
}

MoMoPayable <|.. VNPayToMoMoAdapter : Implements
VNPayPayable <|.. VNPayImpl : Implements
VNPayToMoMoAdapter "1" o-- "1" VNPayPayable : wraps / adapts
@enduml
```

---

### MẪU 7: FAÇADE PATTERN (Máy chủ gửi tin nhắn Viettel)
* **Bản chất kiến trúc:** `ScheduleServerFacade` sở hữu quan hệ Composition (`*--`) trực tiếp với 6 hệ thống con để thống nhất một giao diện điều khiển đơn giản.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

class ScheduleServerFacade {
    - configReader: ConfigurationReader
    - securityManager: SecurityContextManager
    - dbPool: DatabaseConnectionPool
    - queueManager: MessageQueueManager
    - btsTransceiver: TelecomBtsTransceiver
    - scheduler: SMSScheduler
    + ScheduleServerFacade()
    + startServer(): void
    + sendCampaignSMS(campaign: String, content: String, phones: List<String>): void
    + stopServer(): void
}

class ConfigurationReader {
    + loadConfig(): void
}

class SecurityContextManager {
    + authenticateGateway(): void
    + revokeTokens(): void
}

class DatabaseConnectionPool {
    + initPool(): void
    + releasePool(): void
}

class MessageQueueManager {
    + initQueue(): void
    + flushAndClose(): void
}

class TelecomBtsTransceiver {
    + connectToBTS(): void
    + disconnectBTS(): void
    + transmit(phone: String, text: String): void
}

class SMSScheduler {
    + startScheduler(): void
    + stopScheduler(): void
}

ScheduleServerFacade "1" *-- "1" ConfigurationReader : manages
ScheduleServerFacade "1" *-- "1" SecurityContextManager : manages
ScheduleServerFacade "1" *-- "1" DatabaseConnectionPool : manages
ScheduleServerFacade "1" *-- "1" MessageQueueManager : manages
ScheduleServerFacade "1" *-- "1" TelecomBtsTransceiver : manages
ScheduleServerFacade "1" *-- "1" SMSScheduler : manages
@enduml
```

---

### MẪU 8: COMPOSITE PATTERN (Cấu trúc phân cấp thẻ HTML / DOM)
* **Bản chất kiến trúc:** `HtmlParentElement` (Composite) và `HtmlElement` (Leaf) đều kế thừa lớp cơ sở `HtmlTag`. Phần tử cha giữ danh sách các `HtmlTag` con.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

abstract class HtmlTag <<abstract>> {
    + {abstract} getTagName(): String
    + {abstract} setStartTag(tag: String): void
    + {abstract} setEndTag(tag: String): void
    + setTagBody(tagBody: String): void
    + addChildTag(htmlTag: HtmlTag): void
    + removeChildTag(htmlTag: HtmlTag): void
    + getChildren(): List<HtmlTag>
    + {abstract} generateHtml(): void
}

class HtmlParentElement {
    - tagName: String
    - startTag: String
    - endTag: String
    - children: List<HtmlTag>
    + HtmlParentElement(tagName: String)
    + addChildTag(htmlTag: HtmlTag): void
    + removeChildTag(htmlTag: HtmlTag): void
    + getChildren(): List<HtmlTag>
    + generateHtml(): void
}

class HtmlElement {
    - tagName: String
    - startTag: String
    - endTag: String
    - tagBody: String
    + HtmlElement(tagName: String)
    + setTagBody(tagBody: String): void
    + generateHtml(): void
}

HtmlTag <|-- HtmlParentElement : Extends
HtmlTag <|-- HtmlElement : Extends
HtmlParentElement "1" *-- "0..*" HtmlTag : children
@enduml
```

---

### MẪU 9: BRIDGE PATTERN (Hệ thống an ninh xe hơi VinFast / Toyota)
* **Bản chất kiến trúc:** Phân cấp Phương tiện `Vehicle` duy trì cầu nối tham chiếu tới phân cấp Hệ thống an ninh `SecurityProduct`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface SecurityProduct <<interface>> {
    + armSystem(): void
    + disarmSystem(): void
    + triggerAlarm(): void
    + locateGPS(): void
    + getSystemName(): String
}

class VinFastSmartSecurity {
    + armSystem(): void
    + disarmSystem(): void
    + triggerAlarm(): void
    + locateGPS(): void
    + getSystemName(): String
}

class ToyotaSafetySense {
    + armSystem(): void
    + disarmSystem(): void
    + triggerAlarm(): void
    + locateGPS(): void
    + getSystemName(): String
}

abstract class Vehicle <<abstract>> {
    # securitySystem: SecurityProduct
    # vehicleModel: String
    + Vehicle(sec: SecurityProduct, model: String)
    + setSecuritySystem(sec: SecurityProduct): void
    + {abstract} lockVehicle(): void
    + {abstract} unlockVehicle(): void
    + {abstract} handleSuspiciousActivity(): void
}

class ElectricCar {
    + ElectricCar(sec: SecurityProduct, model: String)
    + lockVehicle(): void
    + unlockVehicle(): void
    + handleSuspiciousActivity(): void
}

class ElectricScooter {
    + ElectricScooter(sec: SecurityProduct, model: String)
    + lockVehicle(): void
    + unlockVehicle(): void
    + handleSuspiciousActivity(): void
}

SecurityProduct <|.. VinFastSmartSecurity : Implements
SecurityProduct <|.. ToyotaSafetySense : Implements

Vehicle <|-- ElectricCar : Extends
Vehicle <|-- ElectricScooter : Extends

Vehicle "1" o-- "1" SecurityProduct : Bridge (has-a)
@enduml
```

---

### MẪU 10: PROXY PATTERN (Kiểm soát truy cập báo cáo doanh số)
* **Bản chất kiến trúc:** Cả `RealReportGeneratorImpl` và `ReportGeneratorProxy` đều cài đặt giao diện `ReportGenerator`. Proxy bọc Real Subject và kiểm tra vai trò qua `UserSession`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface ReportGenerator <<interface>> {
    + generateDailySalesReport(date: String): String
    + generateFinancialAuditReport(year: String): String
}

class RealReportGeneratorImpl {
    + RealReportGeneratorImpl()
    + generateDailySalesReport(date: String): String
    + generateFinancialAuditReport(year: String): String
}

class ReportGeneratorProxy {
    - userSession: UserSession
    - realGenerator: RealReportGeneratorImpl
    - cache: Map<String, String>
    + ReportGeneratorProxy(userSession: UserSession)
    - initRealGeneratorIfNeeded(): void
    + generateDailySalesReport(date: String): String
    + generateFinancialAuditReport(year: String): String
}

class UserSession {
    - username: String
    - role: String
    + UserSession(username: String, role: String)
    + getUsername(): String
    + getRole(): String
}

ReportGenerator <|.. RealReportGeneratorImpl : Implements
ReportGenerator <|.. ReportGeneratorProxy : Implements

ReportGeneratorProxy "1" o-- "1" RealReportGeneratorImpl : delegates
ReportGeneratorProxy "1" o-- "1" UserSession : checks role
@enduml
```

---

### MẪU 11: FLYWEIGHT PATTERN (Bộ tối ưu bộ nhớ chấm code online DTPM)
* **Bản chất kiến trúc:** `PlatformFactory` quản lý bộ nhớ đệm các đối tượng Flyweight `ExecutionPlatform` (trạng thái nội tại Intrinsic), tái sử dụng khi nhận bài nộp `CodeSubmission` (trạng thái ngoại lai Extrinsic).

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

class CodeSubmission {
    - studentId: String
    - studentName: String
    - sourceCode: String
    - testCaseCount: int
    + CodeSubmission(id: String, name: String, code: String, tc: int)
    + getStudentId(): String
    + getStudentName(): String
    + getSourceCode(): String
    + getTestCaseCount(): int
}

interface Platform <<interface>> {
    + execute(submission: CodeSubmission): void
    + getPlatformName(): String
}

class ExecutionPlatform {
    - language: String
    - compilerPath: String
    - runtimeFlags: String
    + ExecutionPlatform(lang: String, compiler: String, flags: String)
    + execute(submission: CodeSubmission): void
    + getPlatformName(): String
}

class PlatformFactory {
    - {static} platformCache: Map<String, Platform>
    + {static} getPlatform(language: String): Platform
    + {static} getCacheSize(): int
}

Platform <|.. ExecutionPlatform : Implements (Intrinsic)
PlatformFactory "1" o-- "1..*" Platform : caches
ExecutionPlatform ..> CodeSubmission : runs (Extrinsic)
@enduml
```

---

### MẪU 12: DECORATOR PATTERN (Thêm topping cho bánh Pizza)
* **Bản chất kiến trúc:** Lớp trang trí trừu tượng `PizzaToppingDecorator` vừa cài đặt giao diện `Pizza`, vừa bọc đối tượng `Pizza` bên trong để mở rộng tính năng động.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface Pizza <<interface>> {
    + getDescription(): String
    + getCost(): double
}

class MargheritaPizza {
    + getDescription(): String
    + getCost(): double
}

class SeafoodPizza {
    + getDescription(): String
    + getCost(): double
}

abstract class PizzaToppingDecorator <<abstract>> {
    # pizza: Pizza
    + PizzaToppingDecorator(pizza: Pizza)
    + getDescription(): String
    + getCost(): double
}

class CheeseTopping {
    + CheeseTopping(pizza: Pizza)
    + getDescription(): String
    + getCost(): double
}

class SausageTopping {
    + SausageTopping(pizza: Pizza)
    + getDescription(): String
    + getCost(): double
}

class MushroomTopping {
    + MushroomTopping(pizza: Pizza)
    + getDescription(): String
    + getCost(): double
}

Pizza <|.. MargheritaPizza : Implements
Pizza <|.. SeafoodPizza : Implements
Pizza <|.. PizzaToppingDecorator : Implements

PizzaToppingDecorator <|-- CheeseTopping : Extends
PizzaToppingDecorator <|-- SausageTopping : Extends
PizzaToppingDecorator <|-- MushroomTopping : Extends

PizzaToppingDecorator "1" o-- "1" Pizza : wraps (has-a)
@enduml
```

---

# PHẦN 3: NHÓM HÀNH VI (BEHAVIORAL PATTERNS) - 6 MẪU

---

### MẪU 13: OBSERVER PATTERN (Bắn SMS tỷ số bóng đá ĐTVN)
* **Bản chất kiến trúc:** Quan hệ Một - Nhiều (1-N). Khi trạng thái trận đấu trong `FootballMatchSubject` thay đổi, nó tự động thông báo tới danh sách các `SMSUserObserver`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface Subject <<interface>> {
    + registerObserver(observer: SMSUserObserver): void
    + removeObserver(observer: SMSUserObserver): void
    + notifyObservers(match: String, score: String, detail: String): void
}

class FootballMatchSubject {
    - matchTitle: String
    - currentScore: String
    - observers: List<SMSUserObserver>
    + FootballMatchSubject(matchTitle: String)
    + registerObserver(observer: SMSUserObserver): void
    + removeObserver(observer: SMSUserObserver): void
    + notifyObservers(match: String, score: String, detail: String): void
    + updateMatchEvent(score: String, minute: String, detail: String): void
    + getCurrentScore(): String
}

class SMSUserObserver {
    - userName: String
    - phoneNumber: String
    + SMSUserObserver(user: String, phone: String)
    + receiveUpdate(match: String, score: String, detail: String): void
    + getUserName(): String
    + getPhoneNumber(): String
}

Subject <|.. FootballMatchSubject : Implements
FootballMatchSubject "1" o-- "0..*" SMSUserObserver : notifies
@enduml
```

---

### MẪU 14: STRATEGY PATTERN (Chiến lược thanh toán & định dạng văn bản)
* **Bản chất kiến trúc:** Lớp Context (`CheckoutService` và `TextEditorContext`) giữ tham chiếu đến giao diện Strategy để hoán đổi thuật toán lúc chạy mà không sửa mã nguồn lớp gọi.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface PaymentStrategy <<interface>> {
    + pay(amount: double, orderId: String): void
    + getStrategyName(): String
}

class VNPayQRStrategy {
    + pay(amount: double, orderId: String): void
    + getStrategyName(): String
}

class MoMoWalletStrategy {
    + pay(amount: double, orderId: String): void
    + getStrategyName(): String
}

class NapasCardStrategy {
    + pay(amount: double, orderId: String): void
    + getStrategyName(): String
}

class CheckoutService {
    - paymentStrategy: PaymentStrategy
    + setPaymentStrategy(strategy: PaymentStrategy): void
    + processOrderPayment(orderId: String, amount: double): void
}

interface TextFormatter <<interface>> {
    + format(text: String): String
    + getFormatType(): String
}

class MarkdownFormatter {
    + format(text: String): String
}

class HTMLFormatter {
    + format(text: String): String
}

class UpperCaseFormatter {
    + format(text: String): String
}

class TextEditorContext {
    - formatter: TextFormatter
    + setFormatter(f: TextFormatter): void
    + publish(text: String): void
}

PaymentStrategy <|.. VNPayQRStrategy : Implements
PaymentStrategy <|.. MoMoWalletStrategy : Implements
PaymentStrategy <|.. NapasCardStrategy : Implements
CheckoutService "1" o-- "1" PaymentStrategy : uses

TextFormatter <|.. MarkdownFormatter : Implements
TextFormatter <|.. HTMLFormatter : Implements
TextFormatter <|.. UpperCaseFormatter : Implements
TextEditorContext "1" o-- "1" TextFormatter : uses
@enduml
```

---

### MẪU 15: STATE PATTERN (Robot nấu ăn thông minh)
* **Bản chất kiến trúc:** `CookingRobotContext` ủy quyền mọi hành vi chuyển đổi cho đối tượng `RobotState` hiện hành.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface RobotState <<interface>> {
    + pressPower(robot: CookingRobotContext): void
    + prepareIngredients(robot: CookingRobotContext, dish: String): void
    + cook(robot: CookingRobotContext): void
    + finishCooking(robot: CookingRobotContext): void
    + getStateName(): String
}

class PowerOffState {
    + pressPower(robot: CookingRobotContext): void
    + prepareIngredients(robot: CookingRobotContext, dish: String): void
    + cook(robot: CookingRobotContext): void
    + finishCooking(robot: CookingRobotContext): void
    + getStateName(): String
}

class StandbyState {
    + pressPower(robot: CookingRobotContext): void
    + prepareIngredients(robot: CookingRobotContext, dish: String): void
    + cook(robot: CookingRobotContext): void
    + finishCooking(robot: CookingRobotContext): void
    + getStateName(): String
}

class PreparingState {
    - dishName: String
    + PreparingState(dish: String)
    + pressPower(robot: CookingRobotContext): void
    + cook(robot: CookingRobotContext): void
    + getStateName(): String
}

class CookingState {
    - dishName: String
    + CookingState(dish: String)
    + pressPower(robot: CookingRobotContext): void
    + finishCooking(robot: CookingRobotContext): void
    + getStateName(): String
}

class CookingRobotContext {
    - currentState: RobotState
    + CookingRobotContext()
    + setState(state: RobotState): void
    + getCurrentState(): RobotState
    + pressPowerButton(): void
    + requestDish(dishName: String): void
    + startCooking(): void
    + completeCooking(): void
}

RobotState <|.. PowerOffState : Implements
RobotState <|.. StandbyState : Implements
RobotState <|.. PreparingState : Implements
RobotState <|.. CookingState : Implements

CookingRobotContext "1" o-- "1" RobotState : currentState
@enduml
```

---

### MẪU 16: CHAIN OF RESPONSIBILITY PATTERN (Chuỗi phân loại tệp tin)
* **Bản chất kiến trúc:** Mỗi đối tượng `FileHandler` giữ một liên kết tự tham chiếu (`nextHandler`) trỏ đến mắt xích kế tiếp trong chuỗi trách nhiệm.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

class FileRecord {
    - fileName: String
    - extension: String
    - sizeBytes: long
    + FileRecord(name: String, ext: String, size: long)
    + getFileName(): String
    + getExtension(): String
    + getSizeBytes(): long
}

abstract class FileHandler <<abstract>> {
    # nextHandler: FileHandler
    + setNextHandler(next: FileHandler): void
    + {abstract} handle(file: FileRecord): void
}

class TextFileHandler {
    - {static} SUPPORTED_EXTS: Set<String>
    + handle(file: FileRecord): void
}

class ExcelFileHandler {
    - {static} SUPPORTED_EXTS: Set<String>
    + handle(file: FileRecord): void
}

class AudioFileHandler {
    - {static} SUPPORTED_EXTS: Set<String>
    + handle(file: FileRecord): void
}

class VideoFileHandler {
    - {static} SUPPORTED_EXTS: Set<String>
    + handle(file: FileRecord): void
}

FileHandler <|-- TextFileHandler : Extends
FileHandler <|-- ExcelFileHandler : Extends
FileHandler <|-- AudioFileHandler : Extends
FileHandler <|-- VideoFileHandler : Extends

FileHandler "1" o-- "0..1" FileHandler : nextHandler
FileHandler ..> FileRecord : processes
@enduml
```

---

### MẪU 17: COMMAND PATTERN (Hàng đợi công việc Thread Pool)
* **Bản chất kiến trúc:** Tách rời hoàn toàn đối tượng gọi lệnh `ThreadPoolJobQueue` (Invoker) khỏi đối tượng thực thi `BankTransactionWorker` (Receiver) thông qua giao diện `JobCommand`.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

interface JobCommand <<interface>> {
    + execute(): void
    + getJobName(): String
}

class BankTransactionWorker {
    + calculateInterest(acc: String, balance: double, rate: double): void
    + exportStatement(customer: String, period: String): void
    + verifyEKYC(cccd: String, name: String): void
}

class InterestCalculationJob {
    - worker: BankTransactionWorker
    - accountId: String
    - balance: double
    - rate: double
    + InterestCalculationJob(...)
    + execute(): void
    + getJobName(): String
}

class ExportStatementJob {
    - worker: BankTransactionWorker
    - customerName: String
    - period: String
    + ExportStatementJob(...)
    + execute(): void
    + getJobName(): String
}

class EKYCVerificationJob {
    - worker: BankTransactionWorker
    - cccd: String
    - fullName: String
    + EKYCVerificationJob(...)
    + execute(): void
    + getJobName(): String
}

class ThreadPoolJobQueue {
    - taskQueue: Queue<JobCommand>
    + submitJob(job: JobCommand): void
    + processAllJobs(): void
}

JobCommand <|.. InterestCalculationJob : Implements
JobCommand <|.. ExportStatementJob : Implements
JobCommand <|.. EKYCVerificationJob : Implements

InterestCalculationJob "1" --> "1" BankTransactionWorker : Receiver
ExportStatementJob "1" --> "1" BankTransactionWorker : Receiver
EKYCVerificationJob "1" --> "1" BankTransactionWorker : Receiver

ThreadPoolJobQueue "1" *-- "0..*" JobCommand : taskQueue
@enduml
```

---

### MẪU 18: TEMPLATE METHOD PATTERN (Quy trình xử lý dữ liệu chuẩn ETL)
* **Bản chất kiến trúc:** Lớp trừu tượng `DataProcessorTemplate` giữ phương thức mẫu `final processDataPipeline()`, các lớp con `MySQLDataProcessor` và `OracleDataProcessor` chỉ kế thừa và ghi đè các bước nguyên thủy trừu tượng.

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0
skinparam monochrome true
skinparam shadowing false
skinparam linetype ortho
skinparam roundcorner 0
skinparam class {
    BackgroundColor White
    ArrowColor Black
    BorderColor Black
}

abstract class DataProcessorTemplate <<abstract>> {
    + processDataPipeline(): void <<final>>
    # {abstract} getDatabaseEngine(): String
    # {abstract} connectDatabase(): void
    # {abstract} extractRawData(): void
    # {abstract} disconnectDatabase(): void
    # cleanAndValidateData(): void
    # transformBusinessData(): void
    # loadIntoDataWarehouse(): void
    # isAuditLoggingRequired(): boolean
    # logAuditMetrics(): void
}

class MySQLDataProcessor {
    # getDatabaseEngine(): String
    # connectDatabase(): void
    # extractRawData(): void
    # disconnectDatabase(): void
}

class OracleDataProcessor {
    # getDatabaseEngine(): String
    # connectDatabase(): void
    # extractRawData(): void
    # disconnectDatabase(): void
    # isAuditLoggingRequired(): boolean
}

DataProcessorTemplate <|-- MySQLDataProcessor : Extends
DataProcessorTemplate <|-- OracleDataProcessor : Extends
@enduml
```

---

## 🏛️ BẢNG TỔNG KẾT KIẾN TRÚC 18 DESIGN PATTERNS CHUẨN GOF

| STT | Mẫu Thiết Kế | Phân Loại | Thành phần tham gia cốt lõi (Không lớp Test) | Mối quan hệ UML đặc trưng |
|:---:|---|:---:|---|---|
| **1** | **Singleton** | Creational | `DatabaseConnection` | `1 --> 1` (Self-Association duy nhất trỏ chính nó qua `- instance`). |
| **2** | **Factory Method** | Creational | `OrderParser`, `OrderParserFactory` (và các lớp con) | `<|--` (extends), `<|..` (implements), `..>` (creates). |
| **3** | **Abstract Factory** | Creational | `XMLParserFactory`, `OrderXMLParser`, `FeedbackXMLParser` | Tạo họ 2 loại sản phẩm parser cho NY và TW. |
| **4** | **Builder** | Creational | `VinFastCar`, `CarBuilder`, `VinFastDirector` | `VinFastDirector o--> CarBuilder ..> VinFastCar`. |
| **5** | **Prototype** | Creational | `AccessControl`, `Cloneable`, `AccessControlRegistry` | `AccessControlRegistry o--> AccessControl` (Deep Clone). |
| **6** | **Adapter** | Structural | `MoMoPayable`, `VNPayPayable`, `VNPayToMoMoAdapter` | `VNPayToMoMoAdapter o--> VNPayPayable` (wraps / adapts). |
| **7** | **Façade** | Structural | `ScheduleServerFacade`, 6 lớp hệ thống con | `ScheduleServerFacade *-- Subsystems` (Composition sống còn). |
| **8** | **Composite** | Structural | `HtmlTag`, `HtmlParentElement`, `HtmlElement` | `HtmlParentElement *-- HtmlTag` (Cây phân cấp chứa con). |
| **9** | **Bridge** | Structural | `Vehicle`, `ElectricCar`, `SecurityProduct` | `Vehicle o--> SecurityProduct` (Cầu nối độc lập). |
| **10** | **Proxy** | Structural | `ReportGenerator`, `ReportGeneratorProxy`, `UserSession` | `ReportGeneratorProxy o--> RealSubject & UserSession`. |
| **11** | **Flyweight** | Structural | `Platform`, `ExecutionPlatform`, `PlatformFactory`, `CodeSubmission` | `PlatformFactory o--> Platform` (Cache Intrinsic State). |
| **12** | **Decorator** | Structural | `Pizza`, `PizzaToppingDecorator`, các Topping | `PizzaToppingDecorator o--> Pizza` (Bọc động đối tượng). |
| **13** | **Observer** | Behavioral | `Subject`, `FootballMatchSubject`, `SMSUserObserver` | `FootballMatchSubject o--> SMSUserObserver` (Quan hệ 1-N). |
| **14** | **Strategy** | Behavioral | `CheckoutService`, `PaymentStrategy` / `TextEditorContext` | `Context o--> Strategy` (Hoán đổi chiến lược). |
| **15** | **State** | Behavioral | `CookingRobotContext`, `RobotState`, 4 States | `CookingRobotContext o--> RobotState` (Chuyển đổi trạng thái). |
| **16** | **Chain of Resp.** | Behavioral | `FileHandler`, 4 Handlers con, `FileRecord` | `FileHandler o--> FileHandler` (Tự trỏ `nextHandler`). |
| **17** | **Command** | Behavioral | `JobCommand`, `ThreadPoolJobQueue`, `BankTransactionWorker` | `ThreadPoolJobQueue *-- JobCommand --> BankWorker`. |
| **18** | **Template Method** | Behavioral | `DataProcessorTemplate`, `MySQLDataProcessor`, `OracleDataProcessor` | `<|--` (Kế thừa khung sườn cố định `final`). |

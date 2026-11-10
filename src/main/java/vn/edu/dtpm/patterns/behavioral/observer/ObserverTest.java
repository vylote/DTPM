package vn.edu.dtpm.patterns.behavioral.observer;

public class ObserverTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ OBSERVER PATTERN: TỶ SỐ BÓNG ĐÁ SMS ---");
        System.out.println("==================================================");

        // 1. Khởi tạo Trận đấu bóng đá Subject
        FootballMatchSubject match = new FootballMatchSubject("Chung kết AFF Cup: Việt Nam vs Thái Lan (SVĐ Mỹ Đình)");

        // 2. Khởi tạo các Observer cổ động viên
        SMSUserObserver fan1 = new SMSUserObserver("Nguyễn Văn An", "0988.111.222");
        SMSUserObserver fan2 = new SMSUserObserver("Trần Thị Bình", "0977.333.444");
        SMSUserObserver fan3 = new SMSUserObserver("Lê Hoàng Long", "0966.555.666");

        // 3. Đăng ký nhận thông báo
        System.out.println("1. Các cổ động viên đăng ký dịch vụ Live SMS:");
        match.registerObserver(fan1);
        match.registerObserver(fan2);
        match.registerObserver(fan3);

        // 4. Diễn biến trận đấu 1
        match.updateMatchEvent("Việt Nam 1 - 0 Thái Lan", "32'", "Tiến Linh đánh đầu dũng mãnh tung lưới đối phương!");

        // 5. Cổ động viên fan3 bận việc nên hủy đăng ký
        System.out.println("\n2. Cổ động viên fan3 hủy đăng ký SMS:");
        match.removeObserver(fan3);

        // 6. Diễn biến trận đấu 2
        match.updateMatchEvent("Việt Nam 2 - 1 Thái Lan", "89'", "Quang Hải thực hiện siêu phẩm sút phạt cong góc chữ A!");
    }
}


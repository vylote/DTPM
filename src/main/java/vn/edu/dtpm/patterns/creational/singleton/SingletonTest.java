package vn.edu.dtpm.patterns.creational.singleton;

public class SingletonTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ SINGLETON PATTERN: DATABASE CONNECTION ---");
        System.out.println("==================================================");

        System.out.println("1. Lấy kết nối CSDL lần thứ nhất (dbConn1):");
        DatabaseConnection dbConn1 = DatabaseConnection.getInstance();

        System.out.println("\n2. Lấy kết nối CSDL lần thứ hai (dbConn2):");
        DatabaseConnection dbConn2 = DatabaseConnection.getInstance();

        System.out.println("\n3. Kiểm tra tính đơn nhất (So sánh địa chỉ bộ nhớ):");
        System.out.println("   Mã băm dbConn1: " + System.identityHashCode(dbConn1));
        System.out.println("   Mã băm dbConn2: " + System.identityHashCode(dbConn2));
        boolean isSame = (dbConn1 == dbConn2);
        System.out.println("   dbConn1 == dbConn2 ? -> " + isSame + " (CHÍNH XÁC CÙNG 1 ĐỐI TƯỢNG)");

        System.out.println("\n4. Thao tác dữ liệu qua đối tượng Singleton:");
        dbConn1.executeQuery("SELECT * FROM don_hang WHERE trang_thai = 'DA_THANH_TOAN'");
        dbConn2.executeUpdate("UPDATE tai_khoan SET so_du = so_du + 500000 WHERE user_id = 'NV001'");

        System.out.println("\n5. Kiểm tra lịch sử câu lệnh trên cả 2 tham chiếu:");
        System.out.println("   Tổng số log ghi nhận: " + dbConn2.getExecutionLogs().size());
        for (String log : dbConn1.getExecutionLogs()) {
            System.out.println("   - " + log);
        }
    }
}


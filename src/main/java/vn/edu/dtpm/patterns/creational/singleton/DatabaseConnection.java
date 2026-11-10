package vn.edu.dtpm.patterns.creational.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mẫu thiết kế Singleton (Creational Pattern)
 * Bài toán: Quản lý kết nối Cơ sở dữ liệu duy nhất cho ứng dụng ngân hàng / thương mại điện tử Việt Nam.
 * Cài đặt theo phương pháp Bill Pugh Singleton (Initialization-on-demand holder idiom)
 * đảm bảo Thread-safe và hiệu năng cao (Lazy loading).
 */
public class DatabaseConnection {

    private final String dbUrl;
    private final String username;
    private final List<String> executionLogs;
    private boolean isConnected;

    // Private constructor ngăn cản việc khởi tạo từ bên ngoài
    private DatabaseConnection() {
        this.dbUrl = "jdbc:postgresql://db.dtpm.vn:5432/vnpay_production";
        this.username = "dtpm_admin";
        this.executionLogs = new ArrayList<>();
        this.isConnected = true;
        System.out.println("[DatabaseConnection] Khởi tạo kết nối duy nhất tới Cơ sở dữ liệu: " + dbUrl);
    }

    // Static nested class giữ instance duy nhất
    private static class SingletonHelper {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    // Phương thức tĩnh toàn cục để lấy instance
    public static DatabaseConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void executeQuery(String sql) {
        if (!isConnected) {
            System.out.println("[DatabaseConnection] Lỗi: Kết nối CSDL đã bị đóng!");
            return;
        }
        String log = "[Thực thi SELECT] SQL: " + sql + " | User: " + username;
        executionLogs.add(log);
        System.out.println("[DatabaseConnection] " + log + " -> Trả về kết quả thành công.");
    }

    public void executeUpdate(String sql) {
        if (!isConnected) {
            System.out.println("[DatabaseConnection] Lỗi: Kết nối CSDL đã bị đóng!");
            return;
        }
        String log = "[Thực thi UPDATE/INSERT] SQL: " + sql + " | User: " + username;
        executionLogs.add(log);
        System.out.println("[DatabaseConnection] " + log + " -> Bản ghi đã được cập nhật thành công.");
    }

    public void disconnect() {
        this.isConnected = false;
        System.out.println("[DatabaseConnection] Đã đóng kết nối an toàn với CSDL: " + dbUrl);
    }

    public void reconnect() {
        this.isConnected = true;
        System.out.println("[DatabaseConnection] Đã tái thiết lập kết nối tới CSDL: " + dbUrl);
    }

    public List<String> getExecutionLogs() {
        return Collections.unmodifiableList(executionLogs);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public boolean isConnected() {
        return isConnected;
    }
}


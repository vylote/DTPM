package vn.edu.dtpm.patterns.behavioral.templatemethod;

/**
 * Concrete Class 1: Quy trình xử lý dữ liệu từ hệ quản trị MySQL.
 */
public class MySQLDataProcessor extends DataProcessorTemplate {
    @Override
    protected String getDatabaseEngine() {
        return "MySQL Cluster (Cơ sở dữ liệu Bán lẻ Tiki)";
    }

    @Override
    protected void connectDatabase() {
        System.out.println("   [MySQL - Bước 1] Khởi tạo kết nối qua HikariCP: jdbc:mysql://10.0.1.20:3306/tiki_orders_db?useSSL=true");
    }

    @Override
    protected void extractRawData() {
        System.out.println("   [MySQL - Bước 2] Trích xuất dữ liệu: Thực thi truy vấn phân trang 'SELECT * FROM orders WHERE created_at >= CURDATE() LIMIT 10000;'");
    }

    @Override
    protected void disconnectDatabase() {
        System.out.println("   [MySQL - Bước 7] Đóng kết nối JDBC MySQL an toàn và giải phóng bộ đệm ResultSet.");
    }
}

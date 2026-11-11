package vn.edu.dtpm.patterns.behavioral.templatemethod;

/**
 * Concrete Class 2: Quy trình xử lý dữ liệu từ hệ quản trị Oracle Database.
 */
public class OracleDataProcessor extends DataProcessorTemplate {
    @Override
    protected String getDatabaseEngine() {
        return "Oracle Database Enterprise (Hệ thống Kế toán ERP Viettel)";
    }

    @Override
    protected void connectDatabase() {
        System.out.println("   [Oracle - Bước 1] Mở phiên làm việc qua Oracle OCI / TNS Listener: jdbc:oracle:thin:@scan.viettel.vn:1521/ERPDB");
    }

    @Override
    protected void extractRawData() {
        System.out.println("   [Oracle - Bước 2] Trích xuất dữ liệu: Sử dụng Oracle Cursor và Flashback Query tối ưu cho 10.000 giao dịch tài chính lớn.");
    }

    @Override
    protected void disconnectDatabase() {
        System.out.println("   [Oracle - Bước 7] Commit giao dịch phân tán XA và ngắt phiên làm việc Oracle Session an toàn.");
    }

    @Override
    protected boolean isAuditLoggingRequired() {
        // Oracle ERP yêu cầu kiểm toán chuyên sâu nghiêm ngặt
        return true;
    }
}

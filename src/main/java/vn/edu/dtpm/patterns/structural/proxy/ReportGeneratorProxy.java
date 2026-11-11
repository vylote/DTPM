package vn.edu.dtpm.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Protection & Caching Proxy: Kiểm soát quyền hạn truy cập (RBAC) và lưu bộ đệm kết quả.
 */
public class ReportGeneratorProxy implements ReportGenerator {
    private final UserSession userSession;
    private RealReportGeneratorImpl realGenerator;
    private final Map<String, String> cache = new HashMap<>();

    public ReportGeneratorProxy(UserSession userSession) {
        this.userSession = userSession;
    }

    private void initRealGeneratorIfNeeded() {
        if (realGenerator == null) {
            realGenerator = new RealReportGeneratorImpl();
        }
    }

    @Override
    public String generateDailySalesReport(String date) {
        // Báo cáo doanh số ngày: Tất cả nhân viên đều có thể xem
        String cacheKey = "DAILY_" + date;
        if (cache.containsKey(cacheKey)) {
            System.out.println("[Proxy - Cache Hit] Lấy dữ liệu báo cáo ngày " + date + " từ bộ nhớ đệm (RAM) cực nhanh.");
            return cache.get(cacheKey);
        }

        System.out.println("[Proxy - Permission Granted] Người dùng: " + userSession.getUsername() + " (" + userSession.getRole() + ") hợp lệ.");
        initRealGeneratorIfNeeded();
        String report = realGenerator.generateDailySalesReport(date);
        cache.put(cacheKey, report);
        return report;
    }

    @Override
    public String generateFinancialAuditReport(String year) {
        // Báo cáo tài chính mật: Chỉ Giám đốc (DIRECTOR) và Quản lý cấp cao (MANAGER) mới được phép
        if (!"DIRECTOR".equalsIgnoreCase(userSession.getRole()) && !"MANAGER".equalsIgnoreCase(userSession.getRole())) {
            String warning = String.format(
                "[Proxy - TRUY CẬP BỊ TỪ CHỐI] CẢNH BÁO AN NINH: Nhân viên '%s' (Quyền: %s) KHÔNG CÓ THẨM QUYỀN xem Báo cáo Tài chính mật năm %s!",
                userSession.getUsername(), userSession.getRole(), year
            );
            System.out.println(warning);
            return warning;
        }

        String cacheKey = "AUDIT_" + year;
        if (cache.containsKey(cacheKey)) {
            System.out.println("[Proxy - Cache Hit] Trả về báo cáo kiểm toán năm " + year + " từ bộ nhớ đệm.");
            return cache.get(cacheKey);
        }

        System.out.println("[Proxy - Auth Success] Xác thực thẩm quyền cấp cao thành công cho: " + userSession.getUsername());
        initRealGeneratorIfNeeded();
        String report = realGenerator.generateFinancialAuditReport(year);
        cache.put(cacheKey, report);
        return report;
    }
}

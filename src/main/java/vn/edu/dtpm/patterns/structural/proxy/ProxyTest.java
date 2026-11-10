package vn.edu.dtpm.patterns.structural.proxy;

public class ProxyTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ PROXY PATTERN: BÁO CÁO DOANH SỐ ---");
        System.out.println("==================================================");

        // 1. Tạo 2 phiên làm việc của nhân viên và quản lý
        UserSession staffSession = new UserSession("nguyenvana_sales", "STAFF");
        UserSession managerSession = new UserSession("tranthib_director", "DIRECTOR");

        ReportGenerator staffProxy = new ReportGeneratorProxy(staffSession);
        ReportGenerator managerProxy = new ReportGeneratorProxy(managerSession);

        // 2. Nhân viên thông thường yêu cầu xem Báo cáo doanh số hàng ngày (Được phép)
        System.out.println("1. Nhân viên kinh doanh yêu cầu xem Báo cáo Doanh số ngày hôm nay:");
        String dailyReport = staffProxy.generateDailySalesReport("08/11/2026");
        System.out.println(dailyReport);

        // 3. Nhân viên cố gắng truy cập Báo cáo kiểm toán tài chính mật (Bị Proxy chặn)
        System.out.println("\n2. Nhân viên cố ý truy cập Báo cáo Tài chính kiểm toán bảo mật:");
        staffProxy.generateFinancialAuditReport("2026");

        // 4. Giám đốc yêu cầu xem Báo cáo kiểm toán tài chính (Được phép)
        System.out.println("\n3. Giám đốc điều hành truy cập Báo cáo Tài chính năm 2026:");
        String auditReport = managerProxy.generateFinancialAuditReport("2026");
        System.out.println(auditReport);

        // 5. Giám đốc xem lại lần 2 (Kiểm tra cơ chế Caching của Proxy)
        System.out.println("\n4. Giám đốc tải lại Báo cáo Tài chính lần thứ hai (Kiểm thử Cache Proxy):");
        managerProxy.generateFinancialAuditReport("2026");
    }
}


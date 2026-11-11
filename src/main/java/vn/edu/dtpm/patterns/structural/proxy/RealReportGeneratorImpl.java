package vn.edu.dtpm.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Real Subject: Đối tượng thật thực hiện tính toán báo cáo chuyên sâu.
 */
public class RealReportGeneratorImpl implements ReportGenerator {
    public RealReportGeneratorImpl() {
        System.out.println("   [RealReportGenerator] Đang nạp dữ liệu phân tích BI (Business Intelligence) từ Data Warehouse...");
    }

    @Override
    public String generateDailySalesReport(String date) {
        return String.format(
            "--- BÁO CÁO DOANH SỐ BÁN HÀNG NGÀY %s ---\n" +
            "   * Tổng số đơn: 15.420 đơn\n" +
            "   * Doanh thu ngày: 3.250.000.000 VNĐ\n" +
            "   * Sàn đóng góp cao nhất: Shopee (58%%), Tiki (27%%), Trực tiếp (15%%)", date
        );
    }

    @Override
    public String generateFinancialAuditReport(String year) {
        return String.format(
            "--- BÁO CÁO KIỂM TOÁN TÀI CHÍNH BẢO MẬT NĂM %s ---\n" +
            "   * Lợi nhuận trước thuế (EBITDA): 128.500.000.000 VNĐ\n" +
            "   * Quỹ đầu tư phát triển R&D: 35.000.000.000 VNĐ\n" +
            "   * Phân bổ cổ tức: 18%% / cổ phần", year
        );
    }
}

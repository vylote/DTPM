package vn.edu.dtpm.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Giao diện dịch vụ tạo báo cáo doanh nghiệp.
 */
public interface ReportGenerator {
    String generateDailySalesReport(String date);
    String generateFinancialAuditReport(String year);
}

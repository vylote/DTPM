package vn.edu.dtpm.patterns.behavioral.templatemethod;

/**
 * Abstract Class: Định nghĩa khung sườn thuật toán quy trình xử lý dữ liệu ETL (Extract - Transform - Load).
 */
public abstract class DataProcessorTemplate {

    /**
     * Template Method (được đánh dấu final để lớp con không thể phá vỡ thứ tự các bước).
     */
    public final void processDataPipeline() {
        System.out.println("\n>>> BẮT ĐẦU QUY TRÌNH XỬ LÝ DỮ LIỆU CHUẨN (ETL) TRÊN: " + getDatabaseEngine());
        connectDatabase();
        extractRawData();
        cleanAndValidateData();
        transformBusinessData();

        // Bước Hook tùy chọn
        if (isAuditLoggingRequired()) {
            logAuditMetrics();
        }

        loadIntoDataWarehouse();
        disconnectDatabase();
        System.out.println("<<< KẾT THÚC PIPELINE XỬ LÝ DỮ LIỆU TRÊN " + getDatabaseEngine() + " THÀNH CÔNG!\n");
    }

    // Các bước nguyên thủy trừu tượng (Primitive Methods) bắt buộc lớp con cài đặt
    protected abstract String getDatabaseEngine();
    protected abstract void connectDatabase();
    protected abstract void extractRawData();
    protected abstract void disconnectDatabase();

    // Các bước chung được chuẩn hóa cho toàn bộ hệ thống
    protected void cleanAndValidateData() {
        System.out.println("   [Quy trình chuẩn - Bước 3] Làm sạch dữ liệu: Loại bỏ dòng trùng lặp, chuẩn hóa định dạng số điện thoại Việt Nam (+84) và mã số thuế.");
    }

    protected void transformBusinessData() {
        System.out.println("   [Quy trình chuẩn - Bước 4] Chuyển đổi dữ liệu kinh doanh: Quy đổi ngoại tệ sang VNĐ, tính thuế GTGT (VAT 10%) và phân loại khách VIP.");
    }

    protected void loadIntoDataWarehouse() {
        System.out.println("   [Quy trình chuẩn - Bước 6] Nạp dữ liệu (Load): Đẩy dữ liệu sạch vào Kho dữ liệu tổng thể (Data Warehouse - OLAP BI).");
    }

    // Hook Method: Cho phép lớp con quyết định có ghi log kiểm toán hay không (mặc định là có)
    protected boolean isAuditLoggingRequired() {
        return true;
    }

    protected void logAuditMetrics() {
        System.out.println("   [Hook - Kiểm toán] Ghi nhận log bảo mật SOC: Đã xử lý 10.000 bản ghi, kiểm tra tính toàn vẹn Checksum SHA-256 hoàn tất.");
    }
}

package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Concrete Handler 2: Xử lý tệp bảng tính Excel (XLS / XLSX).
 */
public class ExcelFileHandler extends FileHandler {
    private static final Set<String> SUPPORTED_EXTS = Set.of("xls", "xlsx");

    @Override
    public void handle(FileRecord file) {
        if (SUPPORTED_EXTS.contains(file.getExtension())) {
            System.out.println(String.format(
                "   [ExcelFileHandler] Đã tiếp nhận bảng tính kế toán: %s -> Đang trích xuất sheet dữ liệu kế toán và đồng bộ vào kho dữ liệu báo cáo.",
                file.getFileName()
            ));
        } else if (nextHandler != null) {
            System.out.println("   [ExcelFileHandler] Không hỗ trợ định dạng ." + file.getExtension() + " -> Chuyển tiếp tới mắt xích tiếp theo...");
            nextHandler.handle(file);
        } else {
            System.out.println("   [Cuối chuỗi] Không thể xử lý tệp: " + file.getFileName());
        }
    }
}

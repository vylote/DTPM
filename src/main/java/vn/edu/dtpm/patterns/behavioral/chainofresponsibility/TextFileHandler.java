package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Concrete Handler 1: Xử lý tệp văn bản (Text / CSV / JSON / MD).
 */
public class TextFileHandler extends FileHandler {
    private static final Set<String> SUPPORTED_EXTS = Set.of("txt", "csv", "json", "md");

    @Override
    public void handle(FileRecord file) {
        if (SUPPORTED_EXTS.contains(file.getExtension())) {
            System.out.println(String.format(
                "   [TextFileHandler] Đã tiếp nhận tệp văn bản: %s (Kích thước: %d KB) -> Đang lập chỉ mục tìm kiếm văn bản toàn văn (Full-text index) và lưu trữ.",
                file.getFileName(), file.getSizeBytes() / 1024
            ));
        } else if (nextHandler != null) {
            System.out.println("   [TextFileHandler] Không hỗ trợ định dạng ." + file.getExtension() + " -> Chuyển tiếp tới mắt xích tiếp theo...");
            nextHandler.handle(file);
        } else {
            System.out.println("   [Cuối chuỗi] Không thể xử lý tệp: " + file.getFileName());
        }
    }
}

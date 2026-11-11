package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Concrete Handler 4: Xử lý tệp video đa phương tiện (MP4 / MKV / AVI).
 */
public class VideoFileHandler extends FileHandler {
    private static final Set<String> SUPPORTED_EXTS = Set.of("mp4", "mkv", "avi");

    @Override
    public void handle(FileRecord file) {
        if (SUPPORTED_EXTS.contains(file.getExtension())) {
            System.out.println(String.format(
                "   [VideoFileHandler] Đã tiếp nhận tệp video: %s (Kích thước: %d MB) -> Đang nén codec H.264 và tạo ảnh thumbnail đại diện.",
                file.getFileName(), file.getSizeBytes() / (1024 * 1024)
            ));
        } else if (nextHandler != null) {
            nextHandler.handle(file);
        } else {
            System.out.println(String.format(
                "   [TỪ CHỐI TỆP] Không có bất kỳ bộ xử lý nào trong chuỗi nhận dạng được tệp: %s (Định dạng .%s không được phép / nghi vấn mã độc)!",
                file.getFileName(), file.getExtension()
            ));
        }
    }
}

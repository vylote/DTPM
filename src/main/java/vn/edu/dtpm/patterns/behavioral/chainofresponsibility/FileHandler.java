package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Đối tượng tệp tin cần phân loại và xử lý.
 */
class FileRecord {
    private final String fileName;
    private final String extension;
    private final long sizeBytes;

    public FileRecord(String fileName, String extension, long sizeBytes) {
        this.fileName = fileName;
        this.extension = extension.toLowerCase();
        this.sizeBytes = sizeBytes;
    }

    public String getFileName() { return fileName; }
    public String getExtension() { return extension; }
    public long getSizeBytes() { return sizeBytes; }
}

/**
 * Handler trừu tượng: Định nghĩa liên kết chuỗi và xử lý tệp tin.
 */
public abstract class FileHandler {
    protected FileHandler nextHandler;

    public void setNextHandler(FileHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(FileRecord file);
}

/**
 * Concrete Handler 1: Xử lý tệp văn bản (Text / CSV / JSON / MD).
 */
class TextFileHandler extends FileHandler {
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

/**
 * Concrete Handler 2: Xử lý tệp bảng tính Excel (XLS / XLSX).
 */
class ExcelFileHandler extends FileHandler {
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

/**
 * Concrete Handler 3: Xử lý tệp âm thanh (MP3 / WAV / AAC).
 */
class AudioFileHandler extends FileHandler {
    private static final Set<String> SUPPORTED_EXTS = Set.of("mp3", "wav", "aac");

    @Override
    public void handle(FileRecord file) {
        if (SUPPORTED_EXTS.contains(file.getExtension())) {
            System.out.println(String.format(
                "   [AudioFileHandler] Đã tiếp nhận tệp âm thanh: %s -> Đang chuyển mã MP3 bitrate 320kbps và chạy nhận diện giọng nói AI Viettel.",
                file.getFileName()
            ));
        } else if (nextHandler != null) {
            System.out.println("   [AudioFileHandler] Không hỗ trợ định dạng ." + file.getExtension() + " -> Chuyển tiếp tới mắt xích tiếp theo...");
            nextHandler.handle(file);
        } else {
            System.out.println("   [Cuối chuỗi] Không thể xử lý tệp: " + file.getFileName());
        }
    }
}

/**
 * Concrete Handler 4: Xử lý tệp video đa phương tiện (MP4 / MKV / AVI).
 */
class VideoFileHandler extends FileHandler {
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


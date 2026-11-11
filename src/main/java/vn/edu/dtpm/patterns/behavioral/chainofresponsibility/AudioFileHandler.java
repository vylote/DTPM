package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Concrete Handler 3: Xử lý tệp âm thanh (MP3 / WAV / AAC).
 */
public class AudioFileHandler extends FileHandler {
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

package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.List;

public class ChainTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ CHAIN OF RESPONSIBILITY: XỬ LÝ FILE ---");
        System.out.println("==================================================");

        // 1. Khởi tạo các mắt xích xử lý
        FileHandler textHandler = new TextFileHandler();
        FileHandler excelHandler = new ExcelFileHandler();
        FileHandler audioHandler = new AudioFileHandler();
        FileHandler videoHandler = new VideoFileHandler();

        // 2. Thiết lập chuỗi trách nhiệm: Text -> Excel -> Audio -> Video
        textHandler.setNextHandler(excelHandler);
        excelHandler.setNextHandler(audioHandler);
        audioHandler.setNextHandler(videoHandler);

        // 3. Danh sách các file thực tế từ người dùng tải lên hệ thống
        List<FileRecord> uploadFiles = List.of(
            new FileRecord("dac_ta_yeu_cau_dtpm.md", "md", 45 * 1024),
            new FileRecord("bang_luong_thang_11_fpt.xlsx", "xlsx", 120 * 1024),
            new FileRecord("podcast_cong_nghe_so.mp3", "mp3", 15 * 1024 * 1024),
            new FileRecord("quang_cao_vinfast_vf9.mp4", "mp4", 150 * 1024 * 1024),
            new FileRecord("keygen_crack_tool.exe", "exe", 2 * 1024 * 1024)
        );

        System.out.println("Bắt đầu đưa các tệp tin qua chuỗi xử lý tự động:\n");
        for (FileRecord file : uploadFiles) {
            System.out.println(">>> Tiếp nhận tệp: " + file.getFileName());
            textHandler.handle(file);
            System.out.println();
        }
    }
}


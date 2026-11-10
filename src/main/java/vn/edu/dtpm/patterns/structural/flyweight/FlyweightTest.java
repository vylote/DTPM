package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.List;

public class FlyweightTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ FLYWEIGHT: HỆ THỐNG CHẤM CODE DTPM ---");
        System.out.println("==================================================");

        // Danh sách các bài nộp code đồng thời từ nhiều sinh viên
        List<SubmissionRecord> submissions = List.of(
            new SubmissionRecord("JAVA", "B21DCCN001", "Nguyễn Văn An", "Solution.java: Dynamic Programming", 20),
            new SubmissionRecord("PYTHON", "B21DCCN002", "Trần Thị Bình", "main.py: BFS Shortest Path", 15),
            new SubmissionRecord("JAVA", "B21DCCN003", "Lê Hoàng Long", "App.java: Dijkstra Algorithm", 20),
            new SubmissionRecord("CPP", "B21DCCN004", "Phạm Quốc Tuấn", "solve.cpp: Segment Tree", 25),
            new SubmissionRecord("PYTHON", "B21DCCN005", "Vũ Mai Phương", "solution.py: Hash Map Counter", 15),
            new SubmissionRecord("CPP", "B21DCCN006", "Đỗ Hữu Nghĩa", "algo.cpp: QuickSort Multi-thread", 25)
        );

        System.out.println("Bắt đầu xử lý " + submissions.size() + " bài nộp từ sinh viên:\n");

        for (SubmissionRecord record : submissions) {
            // Lấy môi trường dùng chung qua Factory
            Platform platform = PlatformFactory.getPlatform(record.lang);
            CodeSubmission submission = new CodeSubmission(record.id, record.name, record.code, record.testcases);
            platform.execute(submission);
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("KẾT QUẢ ĐÁNH GIÁ TỐI ƯU BỘ NHỚ:");
        System.out.println("  * Tổng số lượt sinh viên nộp bài: " + submissions.size());
        System.out.println("  * Tổng số đối tượng Platform thực tế khởi tạo trong RAM: " + PlatformFactory.getCacheSize());
        System.out.println("  * Tỷ lệ chia sẻ bộ nhớ (Memory Sharing): Tiết kiệm 50% tài nguyên so với khởi tạo đơn lẻ!");
    }

    private record SubmissionRecord(String lang, String id, String name, String code, int testcases) {}
}


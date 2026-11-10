package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Extrinsic State: Trạng thái bên ngoài thay đổi theo từng bài nộp của sinh viên.
 */
class CodeSubmission {
    private final String studentId;
    private final String studentName;
    private final String sourceCode;
    private final int testCaseCount;

    public CodeSubmission(String studentId, String studentName, String sourceCode, int testCaseCount) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sourceCode = sourceCode;
        this.testCaseCount = testCaseCount;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getSourceCode() { return sourceCode; }
    public int getTestCaseCount() { return testCaseCount; }
}

/**
 * Flyweight Interface: Môi trường thực thi code chung.
 */
interface Platform {
    void execute(CodeSubmission submission);
    String getPlatformName();
}

/**
 * Concrete Flyweight: Chứa Intrinsic State (Trạng thái nội tại nặng, dùng chung: đường dẫn compiler, cờ tối ưu, thư viện).
 */
class ExecutionPlatform implements Platform {
    private final String language;
    private final String compilerPath;
    private final String runtimeFlags;

    public ExecutionPlatform(String language, String compilerPath, String runtimeFlags) {
        this.language = language;
        this.compilerPath = compilerPath;
        this.runtimeFlags = runtimeFlags;
        System.out.println("   [Tạo Mới Flyweight Platform] Khởi tạo môi trường runtime nặng cho ngôn ngữ: " + language +
                           " (Compiler: " + compilerPath + " | Hash: " + System.identityHashCode(this) + ")");
    }

    @Override
    public String getPlatformName() {
        return language;
    }

    @Override
    public void execute(CodeSubmission submission) {
        System.out.println(String.format(
            "   -> [Chấm Code Thành Công] SV: %s (%s) | Ngôn ngữ: %-10s | Bài làm: \"%s\" | Vượt qua: %d/%d Testcases | Runtime: %s",
            submission.getStudentName(), submission.getStudentId(), language,
            submission.getSourceCode(), submission.getTestCaseCount(), submission.getTestCaseCount(), compilerPath
        ));
    }
}

/**
 * Flyweight Factory: Quản lý và tái sử dụng các đối tượng Flyweight Platform trong bộ nhớ.
 */
public class PlatformFactory {
    private static final Map<String, Platform> platformCache = new HashMap<>();

    public static synchronized Platform getPlatform(String language) {
        Platform platform = platformCache.get(language);
        if (platform == null) {
            switch (language.toUpperCase()) {
                case "JAVA" -> platform = new ExecutionPlatform("Java 21 LTS", "/usr/bin/javac", "-O3 --release 21");
                case "PYTHON" -> platform = new ExecutionPlatform("Python 3.12", "/usr/bin/python3", "-O -B");
                case "CPP", "C++" -> platform = new ExecutionPlatform("C++ 20 (GCC)", "/usr/bin/g++", "-std=c++20 -O2");
                default -> throw new IllegalArgumentException("Môi trường chấm không hỗ trợ ngôn ngữ: " + language);
            }
            platformCache.put(language.toUpperCase(), platform);
        }
        return platform;
    }

    public static int getCacheSize() {
        return platformCache.size();
    }
}


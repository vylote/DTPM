package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete Flyweight: Chứa Intrinsic State (Trạng thái nội tại nặng, dùng chung: đường dẫn compiler, cờ tối ưu, thư viện).
 */
public class ExecutionPlatform implements Platform {
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

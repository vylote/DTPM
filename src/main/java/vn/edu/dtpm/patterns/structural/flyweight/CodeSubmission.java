package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Extrinsic State: Trạng thái bên ngoài thay đổi theo từng bài nộp của sinh viên.
 */
public class CodeSubmission {
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

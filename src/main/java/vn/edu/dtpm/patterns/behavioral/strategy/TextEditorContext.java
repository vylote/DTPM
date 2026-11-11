package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Context: Trình soạn thảo văn bản hỗ trợ chuyển đổi thuật toán định dạng tại runtime.
 */
public class TextEditorContext {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
        System.out.println("[TextEditor] Đã chuyển đổi định dạng sang: " + formatter.getFormatType());
    }

    public void publish(String text) {
        if (formatter == null) {
            System.out.println("[TextEditor] Lỗi: Chưa chọn bộ định dạng văn bản!");
            return;
        }
        System.out.println("--- Kết quả định dạng ---");
        System.out.println(formatter.format(text));
        System.out.println("-------------------------");
    }
}

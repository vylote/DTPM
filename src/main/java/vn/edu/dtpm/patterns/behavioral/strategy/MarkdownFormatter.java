package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 2A: Định dạng theo chuẩn Markdown.
 */
public class MarkdownFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "Markdown";
    }

    @Override
    public String format(String text) {
        return "### " + text + "\n> **Nội dung:** *" + text + "*\n- Đã kiểm duyệt định dạng Markdown.";
    }
}

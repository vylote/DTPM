package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Strategy Interface 2: Chiến lược định dạng và xuất bản nội dung văn bản.
 */
public interface TextFormatter {
    String format(String text);
    String getFormatType();
}

/**
 * Concrete Strategy 2A: Định dạng theo chuẩn Markdown.
 */
class MarkdownFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "Markdown";
    }

    @Override
    public String format(String text) {
        return "### " + text + "\n> **Nội dung:** *" + text + "*\n- Đã kiểm duyệt định dạng Markdown.";
    }
}

/**
 * Concrete Strategy 2B: Định dạng theo chuẩn HTML.
 */
class HTMLFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "HTML";
    }

    @Override
    public String format(String text) {
        return "<div class=\"article-content\">\n  <h3>" + text + "</h3>\n  <p>" + text + "</p>\n</div>";
    }
}

/**
 * Concrete Strategy 2C: Định dạng in hoa toàn bộ (Upper Case / Tiếng Việt).
 */
class UpperCaseFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "Chữ In Hoa (Uppercase)";
    }

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}

/**
 * Context: Trình soạn thảo văn bản hỗ trợ chuyển đổi thuật toán định dạng tại runtime.
 */
class TextEditorContext {
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


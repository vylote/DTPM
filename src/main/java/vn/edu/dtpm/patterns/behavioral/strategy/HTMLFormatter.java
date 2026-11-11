package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 2B: Định dạng theo chuẩn HTML.
 */
public class HTMLFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "HTML";
    }

    @Override
    public String format(String text) {
        return "<div class=\"article-content\">\n  <h3>" + text + "</h3>\n  <p>" + text + "</p>\n</div>";
    }
}

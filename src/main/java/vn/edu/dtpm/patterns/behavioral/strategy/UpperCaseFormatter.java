package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Concrete Strategy 2C: Định dạng in hoa toàn bộ (Upper Case / Tiếng Việt).
 */
public class UpperCaseFormatter implements TextFormatter {
    @Override
    public String getFormatType() {
        return "Chữ In Hoa (Uppercase)";
    }

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}

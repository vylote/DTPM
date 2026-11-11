package vn.edu.dtpm.patterns.behavioral.strategy;

/**
 * Strategy Interface 2: Chiến lược định dạng và xuất bản nội dung văn bản.
 */
public interface TextFormatter {
    String format(String text);
    String getFormatType();
}

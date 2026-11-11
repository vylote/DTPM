package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Đối tượng tệp tin cần phân loại và xử lý.
 */
public class FileRecord {
    private final String fileName;
    private final String extension;
    private final long sizeBytes;

    public FileRecord(String fileName, String extension, long sizeBytes) {
        this.fileName = fileName;
        this.extension = extension.toLowerCase();
        this.sizeBytes = sizeBytes;
    }

    public String getFileName() { return fileName; }
    public String getExtension() { return extension; }
    public long getSizeBytes() { return sizeBytes; }
}

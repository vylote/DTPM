package vn.edu.dtpm.patterns.behavioral.chainofresponsibility;

import java.util.Set;

/**
 * Handler trừu tượng: Định nghĩa liên kết chuỗi và xử lý tệp tin.
 */
public abstract class FileHandler {
    protected FileHandler nextHandler;

    public void setNextHandler(FileHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(FileRecord file);
}

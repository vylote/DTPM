package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class DatabaseConnectionPool {
    public void initPool() {
        System.out.println("[Subsystem - DB] Khởi tạo kết nối Pool lưu trữ lịch sử tin nhắn SMS");
    }
    public void releasePool() {
        System.out.println("[Subsystem - DB] Đóng an toàn các kết nối CSDL Pool");
    }
}

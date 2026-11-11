package vn.edu.dtpm.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Phiên làm việc của người dùng truy cập báo cáo.
 */
public class UserSession {
    private final String username;
    private final String role; // "DIRECTOR", "MANAGER", "STAFF"

    public UserSession(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }
}

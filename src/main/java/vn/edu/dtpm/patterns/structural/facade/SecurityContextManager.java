package vn.edu.dtpm.patterns.structural.facade;

import java.util.List;

public class SecurityContextManager {
    public void authenticateGateway() {
        System.out.println("[Subsystem - Security] Xác thực chứng chỉ SSL/TLS và khóa bí mật Viettel CA");
    }
    public void revokeTokens() {
        System.out.println("[Subsystem - Security] Thu hồi toàn bộ Access Token của phiên làm việc");
    }
}

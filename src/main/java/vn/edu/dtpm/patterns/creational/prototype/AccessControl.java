package vn.edu.dtpm.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Prototype: Cấu hình phân quyền truy cập hệ thống FPT Corporation.
 * Cài đặt cơ chế Deep Clone để đảm bảo tính độc lập giữa các phiên bản nhân bản.
 */
public class AccessControl implements Cloneable {
    private String roleName;
    private String assignedUser;
    private String department;
    private List<String> permissions;

    public AccessControl(String roleName, String assignedUser, String department, List<String> permissions) {
        this.roleName = roleName;
        this.assignedUser = assignedUser;
        this.department = department;
        this.permissions = new ArrayList<>(permissions);
    }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getAssignedUser() { return assignedUser; }
    public void setAssignedUser(String assignedUser) { this.assignedUser = assignedUser; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<String> getPermissions() { return permissions; }

    public void addPermission(String permission) {
        if (!permissions.contains(permission)) {
            permissions.add(permission);
        }
    }

    public void revokePermission(String permission) {
        permissions.remove(permission);
    }

    // Cơ chế Deep Clone sao chép toàn bộ danh sách quyền riêng biệt
    @Override
    public AccessControl clone() {
        try {
            AccessControl cloned = (AccessControl) super.clone();
            // Deep copy danh sách quyền để không ảnh hưởng Prototype gốc
            cloned.permissions = new ArrayList<>(this.permissions);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Lỗi nhân bản Prototype phân quyền: " + e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return String.format(
            "   [Phân Quyền FPT] Vai trò: %-16s | Nhân viên: %-22s | Khối: %-15s | Quyền hạn: %s",
            roleName, assignedUser, department, permissions
        );
    }
}

/**
 * Registry quản lý các mẫu quyền gốc trong hệ thống FPT.
 */
class AccessControlRegistry {
    private static final Map<String, AccessControl> REGISTRY = new HashMap<>();

    static {
        // 1. Mẫu quyền System Admin FPT
        REGISTRY.put("ADMIN_TEMPLATE", new AccessControl(
                "FPT_SYSTEM_ADMIN",
                "MẪU CHUẨN ĐỊNH SẴN",
                "FPT Corporate IT",
                List.of("READ_ALL_DATA", "WRITE_ALL_DATA", "DEPLOY_PRODUCTION", "MANAGE_ACCOUNTS", "VIEW_AUDIT_LOG")
        ));

        // 2. Mẫu quyền Software Engineer FPT Software
        REGISTRY.put("DEV_TEMPLATE", new AccessControl(
                "FPT_SOFTWARE_DEV",
                "MẪU CHUẨN ĐỊNH SẴN",
                "FPT Software",
                List.of("READ_REPOSITORY", "PUSH_DEV_BRANCH", "RUN_UNIT_TEST", "CREATE_PULL_REQUEST")
        ));

        // 3. Mẫu quyền Project Manager (PM)
        REGISTRY.put("PM_TEMPLATE", new AccessControl(
                "FPT_PROJECT_MANAGER",
                "MẪU CHUẨN ĐỊNH SẴN",
                "FPT Information System",
                List.of("VIEW_JIRA_DASHBOARD", "ASSIGN_TASKS", "APPROVE_LEAVE", "VIEW_RESOURCE_COST")
        ));
    }

    public static AccessControl getPrototype(String key) {
        AccessControl template = REGISTRY.get(key);
        if (template == null) {
            throw new IllegalArgumentException("Không tìm thấy mẫu phân quyền với khóa: " + key);
        }
        return template.clone(); // Luôn trả về bản sao độc lập
    }

    public static AccessControl getRawTemplate(String key) {
        return REGISTRY.get(key);
    }
}


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

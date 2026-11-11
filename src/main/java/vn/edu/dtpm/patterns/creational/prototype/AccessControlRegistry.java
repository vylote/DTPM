package vn.edu.dtpm.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registry quản lý các mẫu quyền gốc trong hệ thống FPT.
 */
public class AccessControlRegistry {
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

package vn.edu.dtpm.patterns.creational.prototype;

public class PrototypeTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ PROTOTYPE PATTERN: PHÂN QUYỀN FPT ---");
        System.out.println("==================================================");

        // 1. Hiển thị Template gốc
        System.out.println("1. Trạng thái bản mẫu Prototype gốc (DEV_TEMPLATE):");
        AccessControl originalDevTemplate = AccessControlRegistry.getRawTemplate("DEV_TEMPLATE");
        System.out.println(originalDevTemplate);

        // 2. Nhân bản quyền cho Lập trình viên Backend
        System.out.println("\n2. Nhân bản và tùy biến quyền cho Kỹ sư Nguyễn Văn An:");
        AccessControl devAn = AccessControlRegistry.getPrototype("DEV_TEMPLATE");
        devAn.setAssignedUser("Nguyễn Văn An (FPT Software)");
        devAn.setDepartment("FPT Software HN - FSU1");
        // Bổ sung quyền thao tác Docker/K8s
        devAn.addPermission("ACCESS_DEV_K8S_CLUSTER");
        System.out.println(devAn);

        // 3. Nhân bản quyền cho Lập trình viên Senior phụ trách Tech Lead
        System.out.println("\n3. Nhân bản và cấp thêm quyền Merge Code cho Kỹ sư Trần Thị Bình:");
        AccessControl leadBinh = AccessControlRegistry.getPrototype("DEV_TEMPLATE");
        leadBinh.setRoleName("FPT_TECH_LEAD");
        leadBinh.setAssignedUser("Trần Thị Bình (FPT Software)");
        leadBinh.setDepartment("FPT Software HCM - Global Unit");
        leadBinh.addPermission("MERGE_PRODUCTION_PR");
        leadBinh.addPermission("VIEW_CODE_QUALITY_SONAR");
        System.out.println(leadBinh);

        // 4. Nhân bản quyền cho Giám đốc Dự án từ PM Template
        System.out.println("\n4. Nhân bản từ PM_TEMPLATE cho Quản lý Lê Hoàng Long:");
        AccessControl pmLong = AccessControlRegistry.getPrototype("PM_TEMPLATE");
        pmLong.setAssignedUser("Lê Hoàng Long (FPT IS)");
        pmLong.addPermission("APPROVE_PROJECT_BUDGET");
        System.out.println(pmLong);

        // 5. Kiểm tra tính độc lập (Deep Clone verification)
        System.out.println("\n5. Kiểm chứng tính độc lập (Bản gốc không bị thay đổi quyền):");
        System.out.println("   Bản gốc DEV_TEMPLATE số lượng quyền: " + originalDevTemplate.getPermissions().size());
        System.out.println("   Bản sao devAn số lượng quyền: " + devAn.getPermissions().size());
        System.out.println("   Bản sao leadBinh số lượng quyền: " + leadBinh.getPermissions().size());
        boolean deepCloneSuccess = (originalDevTemplate.getPermissions().size() != devAn.getPermissions().size());
        System.out.println("   -> Kết luận Deep Clone: " + (deepCloneSuccess ? "THÀNH CÔNG HOÀN TOÀN!" : "THẤT BẠI"));
    }
}


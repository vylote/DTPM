package vn.edu.dtpm.patterns.behavioral.state;

public class StateTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ STATE PATTERN: ROBOT NẤU ĂN THÔNG MINH ---");
        System.out.println("==================================================");

        CookingRobotContext robot = new CookingRobotContext();

        // 1. Thao tác sai khi máy đang tắt
        System.out.println("1. Thử yêu cầu nấu khi Robot chưa bật nguồn:");
        robot.requestDish("Bò Xào Cần Tỏi");

        // 2. Bật nguồn Robot
        System.out.println("\n2. Bật nguồn Robot:");
        robot.pressPowerButton();

        // 3. Đặt món ăn
        System.out.println("\n3. Đặt món 'Bò Xào Cần Tỏi':");
        robot.requestDish("Bò Xào Cần Tỏi");

        // 4. Bắt đầu nấu
        System.out.println("\n4. Bắt đầu nấu ăn:");
        robot.startCooking();

        // 5. Thử tắt nguồn khi bếp đang nấu (Kiểm tra an toàn)
        System.out.println("\n5. Thử nhấn nút nguồn khi đang nấu nhiệt độ cao:");
        robot.pressPowerButton();

        // 6. Nấu hoàn tất và dọn món
        System.out.println("\n6. Hoàn tất quá trình nấu:");
        robot.completeCooking();

        // 7. Tắt nguồn an toàn
        System.out.println("\n7. Tắt nguồn khi robot đã về trạng thái chờ:");
        robot.pressPowerButton();
    }
}


package vn.edu.dtpm.patterns.behavioral.state;

/**
 * Trạng thái 1: Robot đang tắt nguồn (Power Off).
 */
public class PowerOffState implements RobotState {
    @Override
    public String getStateName() {
        return "TẮT NGUỒN (POWER OFF)";
    }

    @Override
    public void pressPower(CookingRobotContext robot) {
        System.out.println("   [Robot] Khởi động hệ thống... Đèn LED xanh bật sáng, kiểm tra cảm biến an toàn OK.");
        robot.setState(new StandbyState());
    }

    @Override
    public void prepareIngredients(CookingRobotContext robot, String dishName) {
        System.out.println("   [Cảnh báo] Không thể chuẩn bị món '" + dishName + "'. Robot chưa được bật nguồn!");
    }

    @Override
    public void cook(CookingRobotContext robot) {
        System.out.println("   [Cảnh báo] Không thể nấu ăn khi Robot đang tắt nguồn!");
    }

    @Override
    public void finishCooking(CookingRobotContext robot) {
        System.out.println("   [Cảnh báo] Robot không có tác vụ nào đang hoạt động.");
    }
}

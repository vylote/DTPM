package vn.edu.dtpm.patterns.behavioral.state;

/**
 * Trạng thái 2: Robot đang ở chế độ chờ (Standby / Idle).
 */
public class StandbyState implements RobotState {
    @Override
    public String getStateName() {
        return "CHỜ LỆNH (STANDBY)";
    }

    @Override
    public void pressPower(CookingRobotContext robot) {
        System.out.println("   [Robot] Tắt nguồn an toàn. Đèn báo tắt, Robot vào chế độ ngủ đông.");
        robot.setState(new PowerOffState());
    }

    @Override
    public void prepareIngredients(CookingRobotContext robot, String dishName) {
        System.out.println("   [Robot] Tiếp nhận thực đơn món: " + dishName + ". Bắt đầu khâu rửa sạch và sơ chế nguyên liệu.");
        robot.setState(new PreparingState(dishName));
    }

    @Override
    public void cook(CookingRobotContext robot) {
        System.out.println("   [Cảnh báo] Chưa có nguyên liệu nào được sơ chế. Vui lòng chọn món trước!");
    }

    @Override
    public void finishCooking(CookingRobotContext robot) {
        System.out.println("   [Robot] Hiện không có món ăn nào đang trong nồi.");
    }
}

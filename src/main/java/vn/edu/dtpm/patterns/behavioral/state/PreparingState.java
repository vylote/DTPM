package vn.edu.dtpm.patterns.behavioral.state;

/**
 * Trạng thái 3: Đang sơ chế nguyên liệu (Preparing).
 */
public class PreparingState implements RobotState {
    private final String dishName;

    public PreparingState(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String getStateName() {
        return "SƠ CHẾ NGUYÊN LIỆU (PREPARING: " + dishName + ")";
    }

    @Override
    public void pressPower(CookingRobotContext robot) {
        System.out.println("   [Cảnh báo] Robot đang dùng dao cắt thái, không thể tắt nguồn ngay để tránh hỏng thiết bị!");
    }

    @Override
    public void prepareIngredients(CookingRobotContext robot, String newDish) {
        System.out.println("   [Cảnh báo] Đang trong quy trình sơ chế '" + dishName + "', không thể nhận thêm món mới!");
    }

    @Override
    public void cook(CookingRobotContext robot) {
        System.out.println("   [Robot] Nguyên liệu đã chuẩn bị xong! Bật bếp từ, thêm dầu ăn gia vị và bắt đầu nấu: " + dishName);
        robot.setState(new CookingState(dishName));
    }

    @Override
    public void finishCooking(CookingRobotContext robot) {
        System.out.println("   [Cảnh báo] Thức ăn còn chưa được nấu chín!");
    }
}

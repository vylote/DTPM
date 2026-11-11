package vn.edu.dtpm.patterns.behavioral.state;

/**
 * Trạng thái 4: Đang nấu nhiệt độ cao (Cooking).
 */
public class CookingState implements RobotState {
    private final String dishName;

    public CookingState(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String getStateName() {
        return "ĐANG NẤU (COOKING: " + dishName + ")";
    }

    @Override
    public void pressPower(CookingRobotContext robot) {
        System.out.println("   [NGUY HIỂM] Bếp đang hoạt động ở nhiệt độ cao 200°C! Cơ chế an toàn khóa nút nguồn để tránh cháy nổ.");
    }

    @Override
    public void prepareIngredients(CookingRobotContext robot, String dishName) {
        System.out.println("   [Cảnh báo] Cánh tay cơ học đang nấu bếp, không thể chuẩn bị thêm món khác lúc này.");
    }

    @Override
    public void cook(CookingRobotContext robot) {
        System.out.println("   [Robot] Đang xào nấu và gia nhiệt đều cho món " + dishName + "...");
    }

    @Override
    public void finishCooking(CookingRobotContext robot) {
        System.out.println("   [Robot] Ting ting! Món '" + dishName + "' đã chín thơm ngon! Tự động bày ra đĩa và dọn dẹp khoang nấu.");
        robot.setState(new StandbyState());
    }
}

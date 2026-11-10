package vn.edu.dtpm.patterns.behavioral.state;

/**
 * State Interface: Xác định các hành vi phụ thuộc vào trạng thái của Robot nấu ăn thông minh.
 */
public interface RobotState {
    void pressPower(CookingRobotContext robot);
    void prepareIngredients(CookingRobotContext robot, String dishName);
    void cook(CookingRobotContext robot);
    void finishCooking(CookingRobotContext robot);
    String getStateName();
}

/**
 * Trạng thái 1: Robot đang tắt nguồn (Power Off).
 */
class PowerOffState implements RobotState {
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

/**
 * Trạng thái 2: Robot đang ở chế độ chờ (Standby / Idle).
 */
class StandbyState implements RobotState {
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

/**
 * Trạng thái 3: Đang sơ chế nguyên liệu (Preparing).
 */
class PreparingState implements RobotState {
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

/**
 * Trạng thái 4: Đang nấu nhiệt độ cao (Cooking).
 */
class CookingState implements RobotState {
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

/**
 * Context: Robot Nấu Ăn Thông Minh quản lý trạng thái hiện tại.
 */
class CookingRobotContext {
    private RobotState currentState;

    public CookingRobotContext() {
        // Trạng thái ban đầu: Tắt nguồn
        this.currentState = new PowerOffState();
    }

    public void setState(RobotState state) {
        this.currentState = state;
        System.out.println("-> [Chuyển trạng thái] Robot hiện ở chế độ: " + state.getStateName());
    }

    public RobotState getCurrentState() {
        return currentState;
    }

    public void pressPowerButton() {
        currentState.pressPower(this);
    }

    public void requestDish(String dishName) {
        currentState.prepareIngredients(this, dishName);
    }

    public void startCooking() {
        currentState.cook(this);
    }

    public void completeCooking() {
        currentState.finishCooking(this);
    }
}


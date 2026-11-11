package vn.edu.dtpm.patterns.behavioral.state;

/**
 * Context: Robot Nấu Ăn Thông Minh quản lý trạng thái hiện tại.
 */
public class CookingRobotContext {
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

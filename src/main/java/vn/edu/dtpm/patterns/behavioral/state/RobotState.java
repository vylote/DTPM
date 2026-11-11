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

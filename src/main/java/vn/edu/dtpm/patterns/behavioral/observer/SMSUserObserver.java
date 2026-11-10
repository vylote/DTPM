package vn.edu.dtpm.patterns.behavioral.observer;

/**
 * Observer: Người dùng đăng ký nhận tin nhắn thông báo biến động tỷ số bóng đá qua mạng viễn thông.
 */
public class SMSUserObserver {
    private final String userName;
    private final String phoneNumber;

    public SMSUserObserver(String userName, String phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void receiveUpdate(String matchTitle, String currentScore, String eventDetail) {
        System.out.println(String.format(
            "   📩 [SMS gửi tới %s - CĐV %s]: Trận [%s] | Tỷ số hiện tại: %s | Chi tiết: %s",
            phoneNumber, userName, matchTitle, currentScore, eventDetail
        ));
    }
}


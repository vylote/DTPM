package vn.edu.dtpm.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject Interface: Giao diện nguồn phát thông tin sự kiện.
 */
public interface Subject {
    void registerObserver(SMSUserObserver observer);
    void removeObserver(SMSUserObserver observer);
    void notifyObservers(String matchTitle, String score, String eventDetail);
}

/**
 * Concrete Subject: Trận đấu bóng đá trực tiếp (Đội tuyển Quốc gia Việt Nam).
 */
class FootballMatchSubject implements Subject {
    private final String matchTitle;
    private String currentScore;
    private final List<SMSUserObserver> observers = new ArrayList<>();

    public FootballMatchSubject(String matchTitle) {
        this.matchTitle = matchTitle;
        this.currentScore = "0 - 0";
    }

    @Override
    public void registerObserver(SMSUserObserver observer) {
        observers.add(observer);
        System.out.println("[Subject Đăng Ký] Cổ động viên " + observer.getUserName() + " (" + observer.getPhoneNumber() + ") đã đăng ký nhận SMS trực tiếp.");
    }

    @Override
    public void removeObserver(SMSUserObserver observer) {
        observers.remove(observer);
        System.out.println("[Subject Hủy Đăng Ký] Cổ động viên " + observer.getUserName() + " đã dừng dịch vụ nhận SMS.");
    }

    @Override
    public void notifyObservers(String matchTitle, String score, String eventDetail) {
        for (SMSUserObserver observer : observers) {
            observer.receiveUpdate(matchTitle, score, eventDetail);
        }
    }

    public void updateMatchEvent(String newScore, String minute, String detail) {
        this.currentScore = newScore;
        System.out.println(String.format("\n⚽ [BÀN THẮNG / SỰ KIỆN PHÚT %s] Tỷ số mới: %s | Diễn biến: %s", minute, newScore, detail));
        notifyObservers(matchTitle, currentScore, detail + " (Phút " + minute + ")");
    }

    public String getCurrentScore() {
        return currentScore;
    }
}


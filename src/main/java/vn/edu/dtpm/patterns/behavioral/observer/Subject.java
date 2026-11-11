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

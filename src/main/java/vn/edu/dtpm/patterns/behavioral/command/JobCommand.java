package vn.edu.dtpm.patterns.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Command Interface: Đóng gói một yêu cầu công việc thành một đối tượng độc lập.
 */
public interface JobCommand {
    void execute();
    String getJobName();
}

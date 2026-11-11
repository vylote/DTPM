package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Interface: Môi trường thực thi code chung.
 */
public interface Platform {
    void execute(CodeSubmission submission);
    String getPlatformName();
}

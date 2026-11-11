package vn.edu.dtpm.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory: Quản lý và tái sử dụng các đối tượng Flyweight Platform trong bộ nhớ.
 */
public class PlatformFactory {
    private static final Map<String, Platform> platformCache = new HashMap<>();

    public static synchronized Platform getPlatform(String language) {
        Platform platform = platformCache.get(language);
        if (platform == null) {
            switch (language.toUpperCase()) {
                case "JAVA" -> platform = new ExecutionPlatform("Java 21 LTS", "/usr/bin/javac", "-O3 --release 21");
                case "PYTHON" -> platform = new ExecutionPlatform("Python 3.12", "/usr/bin/python3", "-O -B");
                case "CPP", "C++" -> platform = new ExecutionPlatform("C++ 20 (GCC)", "/usr/bin/g++", "-std=c++20 -O2");
                default -> throw new IllegalArgumentException("Môi trường chấm không hỗ trợ ngôn ngữ: " + language);
            }
            platformCache.put(language.toUpperCase(), platform);
        }
        return platform;
    }

    public static int getCacheSize() {
        return platformCache.size();
    }
}

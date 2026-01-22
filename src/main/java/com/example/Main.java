package com.example;

import com.example.analyzer.DataAnalyzer;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        List<String> lines = List.of(
                "2025-01-01 10:00:00 INFO Application started",
                "2025-01-01 10:05:23 ERROR Database timeout",
                "2025-01-01 10:07:11 WARN Cache miss",
                "2025-01-01 10:10:00 ERROR Email failed",
                "",                          // ← пустая строка — игнорировать
                "2025-01-01 invalid line",   // ← невалидный формат — игнорировать
                "another bad line"           // ← не по формату — игнорировать
        );

        System.out.println(DataAnalyzer.analyze(lines));
    }
}

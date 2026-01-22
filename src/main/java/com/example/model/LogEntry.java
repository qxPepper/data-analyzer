package com.example.model;

import java.time.LocalDateTime;

public class LogEntry {
    private final String message;
    private final String level;     // "INFO", "WARN", "ERROR"
    private final LocalDateTime timestamp;

    public LogEntry(String message, String level, LocalDateTime timestamp) {
        this.message = message;
        this.level = level;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getLevel() {
        return level;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

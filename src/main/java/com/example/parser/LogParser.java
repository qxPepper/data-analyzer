package com.example.parser;

import com.example.model.LogEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;

public class LogParser {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Optional<LogEntry> parse(String line) {
        Optional<String[]> array = Optional.ofNullable(line)
                .filter(f -> !f.isBlank())
                .map(m -> m.split(" "))
                .filter(f -> f.length > 3);

        return Optional.ofNullable(array)
                .filter(f -> !message(f).orElse("").isBlank()
                        && !level(f).orElse("").isBlank()
                        && timestamp(f).isPresent())
                .flatMap(arr -> Optional.of(
                                new LogEntry(
                                        message(array).orElse(""),
                                        level(array).orElse(""),
                                        timestamp(array).orElse(null)
                                )
                        )
                );
    }

    private static Optional<LocalDateTime> timestamp(Optional<String[]> array) {
        return array
                .flatMap(fl -> {
                    try {
                        return Optional.ofNullable(LocalDateTime.parse(fl[0] + " " + fl[1], formatter));
                    } catch (DateTimeParseException e) {
                        return Optional.empty();
                    }
                });
    }

    private static Optional<String> level(Optional<String[]> array) {
        return array
                .map(m -> m[2])
                .filter(f -> f.equals("INFO") || f.equals("WARN") || f.equals("ERROR"));
    }

    private static Optional<String> message(Optional<String[]> array) {
        return array
                .map(m -> String.join(" ", Arrays.copyOfRange(m, 3, m.length)))
                .filter(f -> !f.isBlank());
    }
}

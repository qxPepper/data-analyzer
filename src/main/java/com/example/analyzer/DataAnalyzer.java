package com.example.analyzer;

import com.example.model.LogEntry;
import com.example.parser.LogParser;

import java.util.List;
import java.util.Optional;

public class DataAnalyzer {

    public static String analyze(List<String> lines) {
        StringBuilder result = new StringBuilder();
        int counter = 0, counterINFO = 0, counterWARN = 0, counterERROR = 0;

        for (String line : lines) {
            Optional<LogEntry> opt = LogParser.parse(line);

            if (opt.isPresent()) {
                LogEntry entry = opt.get();
                counter++;

                Optional.of(entry.getLevel().equals("INFO") ? counterINFO++ : counterINFO);
                Optional.of(entry.getLevel().equals("WARN") ? counterWARN++ : counterWARN);
                Optional.of(entry.getLevel().equals("ERROR") ? counterERROR++ : counterERROR);
            }
        }

        result.append("=== АНАЛИЗ ЗАВЕРШЁН ===").append("\n");
        result.append("Всего записей: ").append(counter).append("\n");

        if (counterINFO > 0) {
            result.append("INFO: ").append(counterINFO).append("\n");
        }

        if (counterWARN > 0) {
            result.append("WARN: ").append(counterWARN).append("\n");
        }

        if (counterERROR > 0) {
            result.append("ERROR: ").append(counterERROR).append("\n");
        }

        return result.toString();
    }
}


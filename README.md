# Decktop Data Analyser
CLI-инструмент для анализа логов на чистой Java 21.  
Использует функциональный стиль: `Optional`, иммутабельные модели.

## Пример работы

Вход:

"2025-01-01 10:00:00 INFO Application started",

"2025-01-01 10:05:23 ERROR Database timeout",

"2025-01-01 10:07:11 WARN Cache miss",

"2025-01-01 10:10:00 ERROR Email failed",

"",

"2025-01-01 invalid line",

"another bad line"


Выход:

=== АНАЛИЗ ЗАВЕРШЁН ===

Всего записей: 4

INFO: 1

WARN: 1

ERROR: 2
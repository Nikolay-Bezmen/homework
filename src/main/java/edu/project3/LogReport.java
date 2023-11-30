package edu.project3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.logging.log4j.core.util.KeyValuePair;

@SuppressWarnings("MagicNumber")
public class LogReport {
    private final LocalDateTime from;
    private final LocalDateTime to;
    private final List<LogRecord> listLogs;
    private final LogAnalysis analysis;

    public LogReport(LogAnalysis logAnalysis) {
        analysis = logAnalysis;
        listLogs = logAnalysis.getTotalLogRecords();
        from = logAnalysis.getDateFrom() == null ? LocalDateTime.of(1970, 1, 1, 0, 0, 0)
            : LocalDateTime.of(logAnalysis.getDateFrom(), LocalTime.of(0, 0, 0));
        to = logAnalysis.getDateTo() == null ? LocalDateTime.now()
            : LocalDateTime.of(logAnalysis.getDateTo(), LocalTime.of(23, 59, 59));
    }

    //1

    private List<KeyValuePair> getTopFifeMorePopularCodeError() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .map(LogRecord::status)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Entry.<Integer, Long>comparingByValue())
            .limit(5)
            .map(e -> new KeyValuePair(e.getKey().toString(), e.getValue().toString()))
            .collect(Collectors.toList());
    }

    //2
    public Integer totalCountRequest() {
        return listLogs.size();
    }

    //3
    public Double averageSizeOfResponse() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .mapToDouble(LogRecord::bodyBytesSend)
            .average()
            .orElse(0);
    }

    //4
    public Entry<LocalDate, Long> getDayWithMoreRequests() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .collect(Collectors.groupingBy(log -> {
                LocalDateTime lcd = log.timeLocal();
                return LocalDate.of(
                    lcd.getYear(),
                    lcd.getMonth(),
                    lcd.getDayOfMonth()
                );
            }, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Entry.comparingByValue())
            .orElse(null);
    }

    //5
    public List<KeyValuePair> getMorePopularRequests() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .map(LogRecord::request)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(5)
            .map(e -> new KeyValuePair(e.getKey(), e.getValue().toString()))
            .toList();
    }

    //6
    public List<KeyValuePair> getResourcesWithMostPopularCodeError404() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .filter(log -> log.status() == 404)
            .map(LogRecord::request)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(5)
            .map(entry -> new KeyValuePair(entry.getKey(), entry.getValue().toString()))
            .toList();
    }

    //7
    public List<KeyValuePair> getDayOfWeekWithCountRequestOnThisDay() {
        return listLogs.stream()
            .filter(log -> {
                LocalDateTime lc = log.timeLocal();
                return lc.isAfter(from) && lc.isBefore(to);
            })
            .map(LogRecord::timeLocal)
            .map(LocalDateTime::getDayOfWeek)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            .map(e -> new KeyValuePair(e.getKey().toString(), e.getValue().toString()))
            .toList();
    }

    public void getReport() {
        List<String> statistics = new LinkedList<>();
        PrettyOutput output = new PrettyOutput(analysis.getPatternFileOutPut());

        statistics.add(output.printTotalInfo(analysis, totalCountRequest(), averageSizeOfResponse()));
        statistics.add(output.printMorePopularRequests(getMorePopularRequests()));
        statistics.add(output.printCodeAnswersStatistic(getTopFifeMorePopularCodeError()));
        statistics.add(output.printDayWithMoreRequests(getDayWithMoreRequests()));
        statistics.add(output.printResourcesWithMostPopularCodeError404(getResourcesWithMostPopularCodeError404()));
        statistics.add(output.printDayOfWeekWithCountRequestsInThisDay(getDayOfWeekWithCountRequestOnThisDay()));

        FileReport.writeReportInFile(analysis.getPatternFileOutPut(), statistics);
    }
}

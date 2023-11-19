package edu.project3;

import java.time.LocalDateTime;

public record LogRecord(
    String remoteAddr,
    String remoteUser,
    LocalDateTime timeLocal,
    String request,
    int status,
    double bodyBytesSend,
    String httpReferer,
    String httpUserAgent
) {
}

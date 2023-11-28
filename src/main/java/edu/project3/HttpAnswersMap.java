package edu.project3;


import org.springframework.http.HttpStatus;

public class HttpAnswersMap {
    public String getMessageFromCode(int code) {
        try {
            HttpStatus status = HttpStatus.resolve(code);
            return status != null ? status.getReasonPhrase() : null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}


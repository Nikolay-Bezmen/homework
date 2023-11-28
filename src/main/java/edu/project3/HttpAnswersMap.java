package edu.project3;

import org.apache.commons.httpclient.HttpStatus;

public class HttpAnswersMap {
    public String getMessageFromCode(int code) {
        try {
            return HttpStatus.getStatusText(code);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}


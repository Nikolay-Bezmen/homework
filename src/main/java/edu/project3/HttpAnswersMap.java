package edu.project3;

@SuppressWarnings("MagicNumber")
public class HttpAnswersMap {
    private final String[] httpCodeAnswers = new String[526];

    public HttpAnswersMap() {
        httpCodeAnswers[100] = "Continue";
        httpCodeAnswers[101] = "Switching Protocols";
        httpCodeAnswers[102] = "Processing";
        httpCodeAnswers[103] = "Early Hints";
        httpCodeAnswers[200] = "OK";
        httpCodeAnswers[201] = "Created";
        httpCodeAnswers[202] = "Accepted";
        httpCodeAnswers[203] = "Non-Authoritative Information";
        httpCodeAnswers[204] = "No Content";
        httpCodeAnswers[205] = "Reset Content";
        httpCodeAnswers[206] = "Partial Content";
        httpCodeAnswers[207] = "Multi-Status";
        httpCodeAnswers[208] = "Already Reported";
        httpCodeAnswers[226] = "IM Used";
        httpCodeAnswers[300] = "Multiple Choices";
        httpCodeAnswers[301] = "Moved Permanently";
        httpCodeAnswers[302] = "Moved Temporarily";
        httpCodeAnswers[303] = "See Other";
        httpCodeAnswers[304] = "Not Modified";
        httpCodeAnswers[305] = "Use Proxy";
        httpCodeAnswers[306] = "зарезервировано";
        httpCodeAnswers[307] = "Temporary Redirect";
        httpCodeAnswers[308] = "Permanent Redirect";
        httpCodeAnswers[400] = "Bad Request";
        httpCodeAnswers[401] = "Unauthorized";
        httpCodeAnswers[402] = "Payment Required";
        httpCodeAnswers[403] = "Forbidden";
        httpCodeAnswers[404] = "Not Found";
        httpCodeAnswers[405] = "Method Not Allowed";
        httpCodeAnswers[406] = "Not Acceptable";
        httpCodeAnswers[407] = "Proxy Authentication Required";
        httpCodeAnswers[408] = "Request Timeout";
        httpCodeAnswers[409] = "Conflict";
        httpCodeAnswers[410] = "Gone";
        httpCodeAnswers[411] = "Length Required";
        httpCodeAnswers[412] = "Precondition Failed";
        httpCodeAnswers[413] = "Payload Too Large";
        httpCodeAnswers[414] = "URI Too Long";
        httpCodeAnswers[415] = "Unsupported Media Type";
        httpCodeAnswers[416] = "Range Not Satisfiable";
        httpCodeAnswers[417] = "Expectation Failed";
        httpCodeAnswers[418] = "I’m a teapot";
        httpCodeAnswers[419] = "Authentication Timeout";
        httpCodeAnswers[421] = "Misdirected Request";
        httpCodeAnswers[422] = "Unprocessable Entity";
        httpCodeAnswers[423] = "Locked";
        httpCodeAnswers[424] = "Failed Dependency";
        httpCodeAnswers[425] = "Too Early";
        httpCodeAnswers[426] = "Upgrade Required";
        httpCodeAnswers[428] = "Precondition Required";
        httpCodeAnswers[429] = "Too Many Requests";
        httpCodeAnswers[431] = "Request Header Fields Too Large";
        httpCodeAnswers[449] = "Retry With";
        httpCodeAnswers[451] = "Unavailable For Legal Reasons";
        httpCodeAnswers[499] = "Client Closed Request";
        httpCodeAnswers[500] = "Internal Server Error";
        httpCodeAnswers[501] = "Not Implemented";
        httpCodeAnswers[502] = "Bad Gateway";
        httpCodeAnswers[503] = "Service Unavailable";
        httpCodeAnswers[504] = "Gateway Timeout";
        httpCodeAnswers[505] = "HTTP Version Not Supported";
        httpCodeAnswers[506] = "Variant Also Negotiates";
        httpCodeAnswers[507] = "Insufficient Storage";
        httpCodeAnswers[508] = "Loop Detected";
        httpCodeAnswers[509] = "Bandwidth Limit Exceeded";
        httpCodeAnswers[510] = "Not Extended";
        httpCodeAnswers[511] = "Network Authentication Required";
        httpCodeAnswers[520] = "Unknown Error";
        httpCodeAnswers[521] = "Web Server Is Down";
        httpCodeAnswers[522] = "Connection Timed Out";
        httpCodeAnswers[523] = "Origin Is Unreachable";
        httpCodeAnswers[524] = "A Timeout Occurred";
        httpCodeAnswers[525] = "SSL Handshake Failed";
    }

    public String getMessageFromCode(int code) {
        try {
            return httpCodeAnswers[code];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}

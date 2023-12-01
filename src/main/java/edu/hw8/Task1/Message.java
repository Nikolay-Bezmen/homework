package edu.hw8.Task1;

public enum Message {
    PERSONALITIES_REQUEST("личности"),
    PERSONALITIES_RESPONSE("Не переходи на личности там, где их нет"),
    INSULTS_REQUEST("оскорбления"),
    INSULTS_RESPONSE("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"),
    STUPID_REQUEST("глупый"),
    STUPID_RESPONSE("А я тебе говорил, что ты глупый? Так вот,"
        + " я забираю свои слова обратно... Ты просто бог идиотизма."),
    INTELLIGENCE_REQUEST("интеллект"),
    INTELLIGENCE_RESPONSE("Чем ниже интеллект, тем громче оскорбления"),
    UNKNOWN_RESPONSE("Неизвестное ключевое слово");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}

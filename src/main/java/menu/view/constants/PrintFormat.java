package menu.view.constants;

public enum PrintFormat {
    RESULT_FORMAT(System.lineSeparator() +
            "메뉴 추천 결과입니다. " + System.lineSeparator() +
            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]" + System.lineSeparator());
    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}

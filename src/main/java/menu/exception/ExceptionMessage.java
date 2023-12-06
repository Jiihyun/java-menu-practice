package menu.exception;

public enum ExceptionMessage {
    INPUT_BLANK("입력값이 공백입니다."),
    DUPLICATED_NAME("중복된 이름이 존재합니다"),
    NAME_LENGTH("이름은 최소 2자 이상부터 4자 이하까지 입력 가능합니다."),
    COACH_COUNT("코치는 최소 2명 이상 5명 이하까지 입력 가능합니다."),
    NON_EXIST_MENU("존재하지 않는 메뉴입니다."),
    NON_EDIBLE_MENU_QUANTITY("못 먹는 메뉴는 최대 2개까지 입력 가능합니다.");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public ProgramException getException() {
        return new ProgramException(this.message);
    }
}

package menu.view.constants;

public enum PrintMessage {
    /*
    InputView
     */
    INPUT_START("점심 메뉴 추천을 시작합니다." + System.lineSeparator()),
    INPUT_COACHES_NAME_MSG("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_NONEDIBLE_MENU_MSG(" (이)가 못 먹는 메뉴를 입력해 주세요.");
       /*
       OutputView
        */

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

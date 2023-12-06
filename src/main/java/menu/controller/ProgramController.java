package menu.controller;

import menu.domain.CoachesNonEdibleMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class ProgramController {
    private final InputView inputView;
    private final OutputView outputView;


    public ProgramController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        CoachesNonEdibleMenus coachesNonEdibleMenus = inputView.readAll();
        // 2. 실행
        // 3. 출력
    }
}

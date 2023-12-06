package menu.controller;

import menu.domain.CoachesNonEdibleMenus;
import menu.domain.RecommendMachine;
import menu.domain.WeeklyMenuCategories;
import menu.domain.constants.MenuCategories;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class ProgramController {
    private final InputView inputView;
    private final OutputView outputView;


    public ProgramController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        CoachesNonEdibleMenus coachesNonEdibleMenus = inputView.readAll();
        List<MenuCategories> weeklyMenuCategories = new WeeklyMenuCategories().getWeeklyMenuCategories();
        RecommendMachine recommendMachine = new RecommendMachine(coachesNonEdibleMenus, weeklyMenuCategories);
        Map<String, List<String>> weeklyMenu = recommendMachine.getWeeklyMenu();
        outputView.printResult(weeklyMenu, weeklyMenuCategories);
    }
}

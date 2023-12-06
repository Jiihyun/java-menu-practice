package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.constants.Menu;
import menu.domain.constants.MenuCategories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendMachine {
    private final CoachesNonEdibleMenus coachesNonEdibleMenus;
    private final List<MenuCategories> weeklyMenuCategories;

    public RecommendMachine(CoachesNonEdibleMenus coachesNonEdibleMenus, List<MenuCategories> weeklyMenuCategories) {
        this.coachesNonEdibleMenus = coachesNonEdibleMenus;
        this.weeklyMenuCategories = weeklyMenuCategories;
    }

    public Map<String, List<String>> getWeeklyMenu() {
        Map<String, List<String>> weeklyMenu = initializeWeeklyMenu();
        for (MenuCategories weeklyMenuCategory : weeklyMenuCategories) {
            for (NonEdibleMenusByCoach nonEdibleMenusByCoach : coachesNonEdibleMenus.getCoachesNonEdibleMenus()) {
                String name = nonEdibleMenusByCoach.name();
                NonEdibleMenus nonEdibleMenus = nonEdibleMenusByCoach.nonEdibleMenus();

                populateWeeklyMenu(weeklyMenu, weeklyMenuCategory, nonEdibleMenus, name);
            }
        }
        return weeklyMenu;
    }

    private void populateWeeklyMenu(Map<String, List<String>> weeklyMenu, MenuCategories weeklyMenuCategory, NonEdibleMenus nonEdibleMenus, String name) {
        while (true) {
            String menuName = Randoms.shuffle(Menu.getMenuNamesInCategory(weeklyMenuCategory)).get(0);

            if (!nonEdibleMenus.hasSameMenuName(menuName) && !weeklyMenu.get(name).contains(menuName)) {
                weeklyMenu.get(name).add(menuName);
                break;
            }
        }
    }

    private Map<String, List<String>> initializeWeeklyMenu() {
        Map<String, List<String>> weeklyMenu = new HashMap<>();
        for (NonEdibleMenusByCoach nonEdibleMenusByCoach : coachesNonEdibleMenus.getCoachesNonEdibleMenus()) {
            String name = nonEdibleMenusByCoach.name();
            weeklyMenu.put(name, new ArrayList<>());
        }
        return weeklyMenu;
    }
}


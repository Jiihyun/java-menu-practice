package menu.domain;

import menu.domain.constants.MenuCategories;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenuCategories {
    private static final int POSSIBLE_CATEGORY_DUPLICATE_COUNT = 2;
    private static final int WEEK_COUNT = 5;

    public List<MenuCategories> getWeeklyMenuCategories() {
        List<MenuCategories> menuCategories = new ArrayList<>();
        while (menuCategories.size() < WEEK_COUNT) {
            MenuCategories category = MenuCategories.getCategory();
            if (isDuplicatedUnderTwo(menuCategories, category)) {
                menuCategories.add(category);
            }
        }
        return menuCategories;
    }

    private boolean isDuplicatedUnderTwo(List<MenuCategories> menuCategories, MenuCategories category) {
        return menuCategories.stream().filter(menuCategory -> menuCategory == category).count() < POSSIBLE_CATEGORY_DUPLICATE_COUNT;
    }
}

package menu.domain;

import menu.domain.constants.MenuCategories;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenuCategories {
    private static final int POSSIBLE_CATEGORY_DUPLICATE_COUNT = 2;
    private static final int WEEK_COUNT = 5;

    public static List<MenuCategories> create() {
        List<MenuCategories> menuCategories = new ArrayList<>();
        for (int weekIndex = 0; weekIndex < WEEK_COUNT; weekIndex++) {
            if (isDuplicatedUnderTwo(menuCategories))
                menuCategories.add(MenuCategories.getCategory());
        }
        return menuCategories;
    }

    private static boolean isDuplicatedUnderTwo(List<MenuCategories> categories) {
        return categories.stream().distinct().count() < POSSIBLE_CATEGORY_DUPLICATE_COUNT;
    }
}

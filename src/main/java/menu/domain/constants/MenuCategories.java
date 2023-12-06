package menu.domain.constants;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public enum MenuCategories {
    NONE("없음", 0),
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private static final List<MenuCategories> menuCategories = List.of(values());
    private final String categoryName;
    private final int categoryIndex;

    MenuCategories(String categoryName, int categoryIndex) {
        this.categoryName = categoryName;
        this.categoryIndex = categoryIndex;
    }

    public static MenuCategories getCategory() {
        return menuCategories.get(Randoms.pickNumberInRange(JAPANESE.categoryIndex, WESTERN.categoryIndex));
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }
}

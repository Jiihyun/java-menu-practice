package menu.domain.constants;

public enum MenuCategories {
    NONE("없음", 0),
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String categoryName;
    private final int categoryIndex;

    MenuCategories(String categoryName, int categoryIndex) {
        this.categoryName = categoryName;
        this.categoryIndex = categoryIndex;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }
}

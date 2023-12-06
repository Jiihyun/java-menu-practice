package menu.domain;

public enum MenuCategories {
    NONE("없음"),
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식"),
    ;

    private final String categoryName;

    MenuCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

package menu.domain.constants;

import menu.exception.ExceptionMessage;

import java.util.List;

import static menu.domain.constants.MenuCategories.*;

public enum Menu {
    NONE("", MenuCategories.NONE),
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISOSHIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSUDON("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HAIKARAISU("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),

    GIMBAP("김밥", KOREAN),
    KIMCHI_STEW("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    DOENJANG_STEW("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    JAEYUKBOKKEUM("제육볶음", KOREAN),

    KANPOONGGI("깐풍기", CHINESE),
    STIR_FRIED_NOODLES("볶음면", CHINESE),
    DONGPA_YUK("동파육", CHINESE),
    JAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPA_TOFU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", CHINESE),
    GOCUJABCHAE("고추잡채", CHINESE),

    PADTHAI("팟타이", ASIAN),
    KHAO_PAD("카오 팟", ASIAN),
    NASI_GORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    PHO("쌀국수", ASIAN),
    TOM_YUM_KOONG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    SUMMER_ROLL("월남쌈", ASIAN),
    BUN_CHA("분짜", ASIAN),

    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    NYOKKI("뇨끼", WESTERN),
    QUICHE("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN);

    private static final List<Menu> menus = List.of(values());
    private final String menuName;
    private final MenuCategories category;

    Menu(String menuName, MenuCategories category) {
        this.menuName = menuName;
        this.category = category;
    }

    public static Menu from(String input) {
        return menus.stream()
                .filter(menu -> menu.menuName.equals(input))
                .findFirst()
                .orElseThrow(ExceptionMessage.NON_EXIST_MENU::getException);
    }

    public static List<String> getMenuNamesInCategory(MenuCategories menuCategory) {
        return menus.stream().filter(menu -> menu.category.equals(menuCategory))
                .map(menu -> menu.menuName).toList();
    }

    public String getMenuName() {
        return menuName;
    }

    public MenuCategories getCategory() {
        return category;
    }
}

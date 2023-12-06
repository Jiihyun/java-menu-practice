package menu.domain;

import menu.domain.constants.Menu;
import menu.validator.NonEdibleMenuValidator;

import java.util.List;

public class NonEdibleMenus {
    private final List<Menu> nonEdibleMenus;

    public NonEdibleMenus(List<String> inputMenus) {
        NonEdibleMenuValidator.validateNonEdibleMenu(inputMenus);
        nonEdibleMenus = inputMenus.stream()
                .map(Menu::from)
                .toList();
    }

    public List<Menu> getNonEdibleMenus() {
        return nonEdibleMenus;
    }

    public boolean hasSameMenuName(String menuName) {
        return nonEdibleMenus
                .stream().anyMatch(menu -> menu.getMenuName().equals(menuName));
    }
}

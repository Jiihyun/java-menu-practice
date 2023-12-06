package menu.domain;

import menu.validator.NonEdibleMenuValidator;

import java.util.List;

public class NonEdibleMenus {
    private final List<Menu> NonEdibleMenus;

    public NonEdibleMenus(List<String> inputMenus) {
        NonEdibleMenuValidator.validateNonEdibleMenu(inputMenus);
        NonEdibleMenus = inputMenus.stream()
                .map(Menu::from)
                .toList();
    }
}

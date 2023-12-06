package menu.validator;

import menu.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonEdibleMenuValidator {
    private static final int MENU_MAXIMUM_COUNT = 2;

    private NonEdibleMenuValidator() {
        throw new AssertionError();
    }

    public static void validateNonEdibleMenu(List<String> inputMenus) {
        validateDuplicatedMenu(inputMenus);
        validateQuantity(inputMenus);
    }

    private static void validateDuplicatedMenu(List<String> inputMenus) {
        Set<String> menus = new HashSet<>();
        for (String menu : inputMenus) {
            if (!menus.add(menu)) {
                throw ExceptionMessage.DUPLICATED_NAME.getException();
            }
        }
    }

    private static void validateQuantity(List<String> inputMenus) {
        if (inputMenus.size() > MENU_MAXIMUM_COUNT) {
            throw ExceptionMessage.NON_EDIBLE_MENU_QUANTITY.getException();
        }
    }
}

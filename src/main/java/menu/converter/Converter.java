package menu.converter;

import java.util.Arrays;
import java.util.List;

import static menu.validator.InputValidator.validateBlank;

public class Converter {
    private static final String REGEX = ",";

    private Converter() {
        throw new AssertionError();
    }

    public static List<String> convertStrToList(String input) {
        validateBlank(input);
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .toList();
    }

    public static List<String> convertStrToListWithoutValidateBlank(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .toList();
    }


}